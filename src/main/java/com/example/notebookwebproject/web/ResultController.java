package com.example.notebookwebproject.web;

import com.example.notebookwebproject.Paging.Notebook;
import com.example.notebookwebproject.Paging.NotebookDAO;
import com.example.notebookwebproject.Paging.NotebookSpecification;
import com.example.notebookwebproject.SQLTEST.infoTEST;
import com.example.notebookwebproject.SQLTEST.infoTESTMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class ResultController {

    @Autowired
    private NotebookDAO notebookDAO;

    @GetMapping("/result")
    public String result(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 6) Pageable pageable,
                         @RequestParam(required = false) String brand,
                         @RequestParam(required = false) String memorysize,
                         @RequestParam(required = false) String cpukind,
                         @RequestParam(required = false) String pricerange,
                         @RequestParam(required = false) String sizeint,
                         @RequestParam(required = false) String weight){
        Page<Notebook> notebookPage;
        if(brand == null && memorysize == null && cpukind == null && pricerange == null && sizeint == null && weight == null) {
            notebookPage = notebookDAO.findAll(pageable);
        }
        else{
            System.out.println(brand + " ram:" + memorysize + " cpukind: "+ cpukind);
            Specification<Notebook> notebookSpecification = specifyCondition(brand, memorysize, cpukind);
            notebookPage = notebookDAO.findAll(notebookSpecification, pageable);
        }
        model.addAttribute("notebookPage",notebookPage);
        return "result";
    }

    public Specification<Notebook> specifyCondition(String brand, String memorysize, String cpukind){
        Specification<Notebook> notebookSpecification;

        if(brand != null && memorysize != null && cpukind != null){
            notebookSpecification = Specification.where(NotebookSpecification.searchBrand(brand).
                    and(NotebookSpecification.searchMemorySize(Integer.parseInt(memorysize))).
                    and(NotebookSpecification.searchCPU(cpukind)));
        } else if(brand != null && memorysize != null && cpukind == null){
            notebookSpecification = Specification.where(NotebookSpecification.searchBrand(brand).
                    and(NotebookSpecification.searchMemorySize(Integer.parseInt(memorysize))));
        } else if(brand != null && memorysize == null && cpukind != null){
            notebookSpecification = Specification.where(NotebookSpecification.searchBrand(brand).
                    and(NotebookSpecification.searchCPU(cpukind)));
        } else if(brand != null && memorysize == null && cpukind == null){
            notebookSpecification = Specification.where(NotebookSpecification.searchBrand(brand));
        } else if(brand == null && memorysize != null && cpukind != null){
            notebookSpecification = Specification.where(NotebookSpecification.searchMemorySize(Integer.parseInt(memorysize)).
                    and(NotebookSpecification.searchCPU(cpukind)));
        } else if(brand == null && memorysize != null && cpukind == null){
            notebookSpecification = Specification.where(NotebookSpecification.searchMemorySize(Integer.parseInt(memorysize)));
        } else{
            notebookSpecification = Specification.where(NotebookSpecification.searchCPU(cpukind));
        }
        return notebookSpecification;
    }
}
