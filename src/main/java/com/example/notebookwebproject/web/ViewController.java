package com.example.notebookwebproject.web;

import com.example.notebookwebproject.SQLTEST.ScoreManager;
import com.example.notebookwebproject.SQLTEST.ScoreManagerMapper;
import com.example.notebookwebproject.SQLTEST.infoTEST;
import com.example.notebookwebproject.SQLTEST.infoTESTMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
@AllArgsConstructor
public class ViewController {

    private infoTESTMapper infoTestMapper;
    private ScoreManagerMapper scoreMangerMapper;
    private WebController webController;

    @GetMapping("/view")
    public String view(Model model){
        //webController.maincardrandom(model);
        viewcardInitial(model);
        return "view";
    }

    /*public void rankingInitial(){
        int rank = 1;
        int id = 1;
        for(int i=0 ; i<10 ; i++){
            for(int j=1; j<=10; j++){
                id = i*100 + j;
                ranking[rank] = id;
                rank++;
            }
        }
    }*/

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

}
