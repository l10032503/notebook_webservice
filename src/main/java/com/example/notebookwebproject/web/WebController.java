package com.example.notebookwebproject.web;

import com.example.notebookwebproject.Paging.Notebook;
import com.example.notebookwebproject.Paging.NotebookDAO;
import com.example.notebookwebproject.SQLTEST.infoTEST;
import com.example.notebookwebproject.SQLTEST.infoTESTMapper;
import com.example.notebookwebproject.game.Game;
import com.example.notebookwebproject.game.GameMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Controller
@AllArgsConstructor
public class WebController {

    private GameMapper gameMapper;
    private infoTESTMapper infoTestMapper;
    @Autowired
    private NotebookDAO notebookDAO;

    @GetMapping("/")
    public String main(Model model){
        getGameURL(model);
        maincardrandom(model);
        return "main";
    }

    @GetMapping("/test")
    public String test(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 6) Pageable pageable){
        Page<Notebook> notebookPage = notebookDAO.findAll(pageable);
        model.addAttribute("notebookPage",notebookPage);
        return "test";
    }

    public void maincardrandom(Model model){
        Date today = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String card_id = "card_id_";
        String card_model = "card_model_";
        String card_pricestring = "card_pricestring_";
        String card_imgurlf = "card_imgurlf_";
        String card_infourl = "card_infoURL_";
        String card_stauts = "card_status_";
        Random random = new Random(Integer.parseInt(simpleDateFormat.format(today)));
        int[] randomid = new int[7];
        int id_hundred = 0;
        int id_one = 1;
        infoTEST[] notebookcards = new infoTEST[7];
        String term_id = "";
        String term_model = "";
        String term_pricestring = "";
        String term_imgurlf = "";
        String term_infourl = "";
        String term_status = "";

        for (int i = 1; i<7; i++){
            id_hundred = random.nextInt(10);
            id_one = random.nextInt(10)+1;
            randomid[i] = id_hundred*100 + id_one;
        }

        for(int i = 1; i < 7; i++) {
            notebookcards[i] = infoTestMapper.findinfotestID(randomid[i]);

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
    private void getGameURL(Model model){
        int[] gameid = new int[31];
        Game[] GameStatus = new Game[31];
        String game_id = "game_id_";
        String game_minos = "game_minos_";
        String game_mincpu = "game_mincpu_";
        String game_mincpuranking = "game_mincpuranking_";

        String term_id = "";

        String gameMinURL = "http://comalmot.com/result?";
        String termMinURL = "";
        String gameRecURL = "http://comalmot.com/result?";
        String termRecURL = "";
        String gameMinStatus = "game_min_";
        String termMinStatus = "";
        String gameRecStatus = "game_rec_";
        String termRecStatus = "";

        for(int i = 1; i<31; i++){
            GameStatus[i] = gameMapper.findgameID(i);
            termMinStatus = gameMinStatus + String.valueOf(i);
            termRecStatus = gameRecStatus + String.valueOf(i);

            termMinURL = gameMinURL;
            termMinURL = termMinURL + "cpurankingless=" + GameStatus[i].getMincpuranking()
                    + "&memorysizegreater=" + GameStatus[i].getMinram()
                    + "&gpurankingless=" + GameStatus[i].getMingpuranking();
            model.addAttribute(termMinStatus, termMinURL);

            termRecURL = gameRecURL;
            termRecURL = termRecURL + "cpurankingless=" + GameStatus[i].getReccpuranking()
                    + "&memorysizegreater=" + GameStatus[i].getRecram()
                    + "&gpurankingless=" + GameStatus[i].getRecgpuranking();
            model.addAttribute(termRecStatus, termRecURL);
        }
    }

}
