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
                         @RequestParam(value="brand", required = false, defaultValue = "0") String[] brand,
                         @RequestParam(value="memorysize",required = false, defaultValue = "0") String[] memorysize,
                         @RequestParam(value="cpukind",required = false, defaultValue = "0") String[] cpukind,
                         @RequestParam(value="pricerange",required = false, defaultValue = "0") String[] pricerange,
                         @RequestParam(value="sizeinch",required = false, defaultValue = "0") String[] sizeinch,
                         @RequestParam(value="weight",required = false, defaultValue = "0") String[] weight,
                         @RequestParam(value="searchbrand",required = false, defaultValue = "0") String[] searchbrand,
                         @RequestParam(value="searchmodel",required = false, defaultValue = "0") String[] searchmodel,
                         @RequestParam(value="searchall",required = false, defaultValue = "0") String[] searchall,
                         @RequestParam(value="cpurankinggreater",required = false) String cpurankinggreater,
                         @RequestParam(value="cpurankingless",required = false) String cpurankingless,
                         @RequestParam(value="os",required = false, defaultValue = "0") String[] os,
                         @RequestParam(value="keyboard",required = false, defaultValue = "0") String[] keyboard,
                         @RequestParam(value="disksize",required = false, defaultValue = "0") String[] disksize,
                         @RequestParam(value="memorysizegreater",required = false) String memorysizegreater,
                         @RequestParam(value="gpurankingless",required = false) String gpurankingless){
        Page<Notebook> notebookPage;
        if(brand[0].equals("0") && memorysize[0].equals("0") && cpukind[0].equals("0") && pricerange[0].equals("0") && sizeinch[0].equals("0")
                && weight[0].equals("0") && searchbrand[0].equals("0") && searchmodel[0].equals("0") && searchall[0].equals("0")
                &&cpurankinggreater==null&&cpurankingless==null&&os[0].equals("0")&&keyboard[0].equals("0")&&disksize[0].equals("0")
                &&memorysizegreater==null&&gpurankingless==null) {
            System.out.println("pageall");
            notebookPage = notebookDAO.findAll(pageable);
        }
        else{
            Specification<Notebook> notebookSpecification
                    = specifyCondition(brand, memorysize, cpukind, pricerange, sizeinch, weight, searchbrand, searchmodel,
                    searchall, cpurankinggreater, cpurankingless, os, keyboard, disksize, memorysizegreater, gpurankingless);
            notebookPage = notebookDAO.findAll(notebookSpecification, pageable);
        }
        model.addAttribute("notebookPage",notebookPage);
        return "result";
    }

    public Specification<Notebook> specifyCondition(String[] brand, String[] memorysize, String[] cpukind,
                                                    String[] pricerange, String[] sizeinch, String[] weight,
                                                    String[] searchbrand, String[] searchmodel, String[] searchall,
                                                    String cpurankinggreater, String cpurakingless, String[] os,
                                                    String[] keyboard, String[] disksize, String memorysizegreater,
                                                    String gpurankingless){
        Specification<Notebook> notebookSpecification = Specification.where(NotebookSpecification.returnDefault());
        if(!brand[0].equals("0")) {
            notebookSpecification = Specification.where(NotebookSpecification.searchBrand(brand));
        }
        else{
            notebookSpecification = Specification.where(NotebookSpecification.returnDefault());
        }
        if(!memorysize[0].equals("0")) {
            int [] memorysizeint = new int[memorysize.length];
            for(int i = 0; i < memorysize.length; i++)
                memorysizeint[i] = Integer.parseInt(memorysize[i]);
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchMemorySize(memorysizeint));
        }
        if(!cpukind[0].equals("0")){
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchCPU(cpukind));
        }
        if(!pricerange[0].equals("0")){
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchPrice(pricerange));
        }
        if(!sizeinch[0].equals("0")) {
            int [] sizeinchint = new int[sizeinch.length];
            for(int i = 0; i < sizeinch.length; i++)
                sizeinchint[i] = Integer.parseInt(sizeinch[i]);
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchSize(sizeinchint));
        }
        if(!weight[0].equals("0")) {
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchWeight(weight));
        }
        if(!searchbrand[0].equals("0")) {
            notebookSpecification = notebookSpecification.and(NotebookSpecification.brandFilter(searchbrand[0]));
        }
        if(!searchmodel[0].equals("0")) {
            notebookSpecification = notebookSpecification.and(NotebookSpecification.modelFilter(searchmodel[0]));
        }
        if(!searchall[0].equals("0")) {
            notebookSpecification = notebookSpecification.and(NotebookSpecification.allFilter(searchall[0]));
        }
        if(cpurankinggreater != null) {
            System.out.println(cpurankinggreater);
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchCPURankingGreater(Integer.parseInt(cpurankinggreater)));
        }
        if(cpurakingless != null) {
            System.out.println(cpurakingless);
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchCPURankingLess(Integer.parseInt(cpurakingless)));
        }
        if(!os[0].equals("0")){
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchOS(os));
        }
        if(!keyboard[0].equals("0")){
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchKeyboard(keyboard));
        }
        if(!disksize[0].equals("0")){
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchDisksize(disksize));
        }
        if(memorysizegreater != null) {
            System.out.println(memorysizegreater);
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchMemorySizeGreater(Integer.parseInt(memorysizegreater)));
        }
        if(gpurankingless != null) {
            System.out.println(gpurankingless);
            notebookSpecification = notebookSpecification.and(NotebookSpecification.searchGPURankingLess(Integer.parseInt(gpurankingless)));
        }
        return notebookSpecification;
    }
}
