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
                         @RequestParam(required = false) String sizeinch,
                         @RequestParam(required = false) String weight,
                         @RequestParam(required = false) String searchbrand,
                         @RequestParam(required = false) String searchmodel,
                         @RequestParam(required = false) String searchall){
        Page<Notebook> notebookPage;
        if(brand == null && memorysize == null && cpukind == null && pricerange == null && sizeinch == null && weight == null && searchbrand == null && searchmodel == null && searchall == null) {
            notebookPage = notebookDAO.findAll(pageable);
        }
        else{
            System.out.println(brand + " ram:" + memorysize + " cpukind: "+ cpukind);
            Specification<Notebook> notebookSpecification
                    = specifyCondition(brand, memorysize, cpukind, pricerange, sizeinch, weight, searchbrand, searchmodel, searchall);
            notebookPage = notebookDAO.findAll(notebookSpecification, pageable);
        }
        model.addAttribute("notebookPage",notebookPage);
        return "result";
    }

    public Specification<Notebook> specifyCondition(String brand, String memorysize, String cpukind, String pricerange, String sizeinch, String weight, String searchbrand, String searchmodel, String searchall){
        Specification<Notebook> notebookSpecification;
        if(brand!=null)
            notebookSpecification = Specification.where(NotebookSpecification.searchBrand(brand));
        else
            notebookSpecification = Specification.where(NotebookSpecification.returnDefault());
        if(memorysize!=null)
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchMemorySize(Integer.parseInt(memorysize)));
        if(cpukind!=null)
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchCPU(cpukind));
        if(pricerange!=null)
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchPrice(pricerange));
        if(sizeinch!=null)
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchSize(Integer.parseInt(sizeinch)));
        if(weight!=null)
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchWeight(weight));
        if(searchbrand!=null)
            notebookSpecification = notebookSpecification.and(NotebookSpecification.brandFilter(searchbrand));
        if(searchmodel!=null)
            notebookSpecification = notebookSpecification.and(NotebookSpecification.modelFilter(searchmodel));
        if(searchall!=null)
            notebookSpecification = notebookSpecification.and(NotebookSpecification.allFilter(searchall));
        return notebookSpecification;
    }
}
