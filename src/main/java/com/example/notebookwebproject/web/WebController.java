package com.example.notebookwebproject.web;

import com.example.notebookwebproject.SQLTEST.infoTEST;
import com.example.notebookwebproject.SQLTEST.infoTESTMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Random;

@Controller
@AllArgsConstructor
public class WebController {

    private infoTESTMapper infoTestMapper;

    @GetMapping("/")
    public String main(final Model model){
        maincardrandom(model);
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

    @GetMapping("/view")
    public String view(){
        return "view";
    }

    public void maincardrandom(Model model){
        String card_id = "card_id_";
        String card_model = "card_model_";
        String card_pricestring = "card_pricestring_";
        String card_imgurlf = "card_imgurlf_";
        String card_infourl = "card_infoURL_";
        String card_stauts = "card_status_";
        Random random = new Random();
        int randomid = 1;
        int id_hundred = 0;
        int id_one = 1;
        infoTEST[] notebookcards = new infoTEST[7];
        String term_id = "";
        String term_model = "";
        String term_pricestring = "";
        String term_imgurlf = "";
        String term_infourl = "";
        String term_status = "";

        for(int i = 1; i < 7; i++) {
            id_hundred = random.nextInt(10);
            id_one = random.nextInt(10)+1;
            randomid = id_hundred*100 + id_one;
            notebookcards[i] = infoTestMapper.findinfotestID(randomid);

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

}
