package com.example.notebookwebproject.web;

import com.example.notebookwebproject.game.Game;
import com.example.notebookwebproject.game.GameMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sound.midi.SysexMessage;
import java.util.Random;

@Controller
@AllArgsConstructor
public class QueryController {

    private GameMapper gameMapper;

    @GetMapping("/query")
    public String querypage(Model model){
        getGameURL(model);
        return "querypage";
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
            System.out.println(termMinStatus);
            System.out.println(termMinURL);

            termRecURL = gameRecURL;
            termRecURL = termRecURL + "cpurankingless=" + GameStatus[i].getReccpuranking()
                    + "&memorysizegreater=" + GameStatus[i].getRecram()
                    + "&gpurankingless=" + GameStatus[i].getRecgpuranking();
            model.addAttribute(termRecStatus, termRecURL);
            System.out.println(termRecStatus);
            System.out.println(termRecURL);
        }
    }

}
