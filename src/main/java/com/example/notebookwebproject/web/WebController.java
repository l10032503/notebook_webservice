package com.example.notebookwebproject.web;

import com.example.notebookwebproject.SQLTEST.infoTEST;
import com.example.notebookwebproject.SQLTEST.infoTESTMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private infoTESTMapper infoTestMapper;

    @GetMapping("/")
    public String main(final Model model){
        maincardinitial(model);
        /*infoTEST notebookcard1 = infoTestMapper.findinfotestID(1);
        model.addAttribute("card1_id", notebookcard1.getID());
        model.addAttribute("card1_model", notebookcard1.getModel());
        model.addAttribute("card1_price", notebookcard1.getPrice());
        model.addAttribute("card1_imgurlf", notebookcard1.getImgURLf());
        model.addAttribute("card1_infoURL", notebookcard1.getInfoURL());*/
        return "main";
    }

    @GetMapping("/result")
    public String result(){
        return "result";
    }

    @GetMapping("/query")
    public String querypage(){
        return "querypage";
    }

    @GetMapping("/maintestpage")
    public String testpage(){
        return "testpage";
    }

    public void maincardinitial(Model model){
        String card_id = "card_id_";
        String card_model = "card_model_";
        String card_pricestring = "card_pricestring_";
        String card_imgurlf = "card_imgurlf_";
        String card_infourl = "card_infourl_";
        int id = 1;
        infoTEST[] notebookcards = new infoTEST[7];
        String term_id = "";
        String term_model = "";
        String term_pricestring = "";
        String term_imgurlf = "";
        String term_infourl = "";

        for(;id<7;id++) {
            notebookcards[id] = infoTestMapper.findinfotestID(id);
            term_id = card_id;
            term_id = term_id + String.valueOf(id);
            model.addAttribute(term_id, notebookcards[id].getID());
            term_model = card_model;
            term_model = term_model + String.valueOf(id);
            model.addAttribute(term_model, notebookcards[id].getModel());
            term_pricestring = card_pricestring;
            term_pricestring = term_pricestring + String.valueOf(id);
            model.addAttribute(term_pricestring, notebookcards[id].getPriceString());
            term_imgurlf = card_imgurlf;
            term_imgurlf = term_imgurlf + String.valueOf(id);
            model.addAttribute(term_imgurlf, notebookcards[id].getImgURLf());
            term_infourl = card_infourl;
            term_infourl = term_infourl + String.valueOf(id);
            model.addAttribute(term_infourl, notebookcards[id].getInfoURL());
        }
    }

}
