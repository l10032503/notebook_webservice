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
public class ViewController {

    private infoTESTMapper infoTestMapper;
    @Autowired
    private NotebookDAO notebookDAO;

    /*@GetMapping("/view")
    public String view(Model model){
        viewcardInitial(model);
        return "view";
    }*/

    @GetMapping("/view")
    public String view(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 6) Pageable pageable,
                       @RequestParam(value="brand", required = false, defaultValue = "0") String[] brand,
                       @RequestParam(value="memorysize",required = false, defaultValue = "0") String[] memorysize,
                       @RequestParam(value="cpukind",required = false, defaultValue = "0") String[] cpukind,
                       @RequestParam(value="pricerange",required = false, defaultValue = "0") String[] pricerange,
                       @RequestParam(value="sizeinch",required = false, defaultValue = "0") String[] sizeinch,
                       @RequestParam(value="weight",required = false, defaultValue = "0") String[] weight,
                       @RequestParam(value="searchbrand",required = false, defaultValue = "0") String[] searchbrand,
                       @RequestParam(value="searchmodel",required = false, defaultValue = "0") String[] searchmodel,
                       @RequestParam(value="searchall",required = false, defaultValue = "0") String[] searchall){
        Page<Notebook> notebookPage;
        if(brand[0].equals("0") && memorysize[0].equals("0") && cpukind[0].equals("0") && pricerange[0].equals("0") && sizeinch[0].equals("0")
                && weight[0].equals("0") && searchbrand[0].equals("0") && searchmodel[0].equals("0") && searchall[0].equals("0")) {
            System.out.println("pageall");
            notebookPage = notebookDAO.findAll(pageable);
        }
        /*if(brand == null && memorysize == null && cpukind == null && pricerange == null && sizeinch == null
                && weight == null && searchbrand == null && searchmodel == null && searchall == null) {
            System.out.println("pageall");
            notebookPage = notebookDAO.findAll(pageable);
        }*/
        else{
            Specification<Notebook> notebookSpecification
                    = specifyCondition(brand, memorysize, cpukind, pricerange, sizeinch, weight, searchbrand, searchmodel, searchall);
            notebookPage = notebookDAO.findAll(notebookSpecification, pageable);
        }
        model.addAttribute("notebookPage",notebookPage);
        return "viewpage";
    }

    public void viewcardInitial(Model model){

        String card_id = "card_id_";
        String card_model = "card_model_";
        String card_pricestring = "card_pricestring_";
        String card_imgurlf = "card_imgurlf_";
        String card_infourl = "card_infoURL_";
        String card_stauts = "card_status_";
        int[] ranking = new int[110];
        int rank = 1;
        int id = 1;
        int page = 1;
        int cardnumber = 1;
        infoTEST[] notebookcards = new infoTEST[7];
        String term_id = "";
        String term_model = "";
        String term_pricestring = "";
        String term_imgurlf = "";
        String term_infourl = "";
        String term_status = "";

        ranking[rank] = 0;
        for(int j=1 ; j<=10 ; j++){
            for(int i=0; i<10; i++){
                id = i*100 + j;
                ranking[rank] = id;
                rank++;
            }
        }

        for(int i = 1; i < 7; i++) {
            cardnumber = (page-1)*6+ i;
            notebookcards[i] = infoTestMapper.findinfotestID(ranking[cardnumber]);

            term_id = card_id;
            term_id = term_id + String.valueOf(i);
            model.addAttribute(term_id, notebookcards[i].getID());

            term_model = card_model;
            term_model = term_model + String.valueOf(i);
            model.addAttribute(term_model, notebookcards[i].getModel());

            term_pricestring = card_pricestring;
            term_pricestring = term_pricestring + String.valueOf(i);
            model.addAttribute(term_pricestring, notebookcards[i].getPriceString());

            term_imgurlf = card_imgurlf;
            term_imgurlf = term_imgurlf + String.valueOf(i);
            model.addAttribute(term_imgurlf, notebookcards[i].getImgURLf());

            term_infourl = card_infourl;
            term_infourl = term_infourl + String.valueOf(i);
            model.addAttribute(term_infourl, notebookcards[i].getInfoURL());

            term_status = card_stauts;
            term_status = term_status + String.valueOf(i);
            model.addAttribute(term_status, notebookcards[i].getStatus());
        }
    }

    public Specification<Notebook> specifyCondition(String[] brand, String[] memorysize, String[] cpukind,
                                                    String[] pricerange, String[] sizeinch, String[] weight,
                                                    String[] searchbrand, String[] searchmodel, String[] searchall){
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
        return notebookSpecification;
    }

}
