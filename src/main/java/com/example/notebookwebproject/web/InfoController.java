package com.example.notebookwebproject.web;

import com.example.notebookwebproject.SQLTEST.infoTEST;
import com.example.notebookwebproject.SQLTEST.infoTESTMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class InfoController {

    private infoTESTMapper infoTestMapper;

    @RequestMapping("/notebookinfo/{ID}")
    public String notebookinfo(@PathVariable int ID, final Model model){
        infoTEST infoTest = infoTestMapper.findinfotestID(ID);
        model.addAttribute("id", infoTest.getID());
        model.addAttribute("model", infoTest.getModel());
        model.addAttribute("price", infoTest.getPrice());
        model.addAttribute("weight", infoTest.getWeight());
        model.addAttribute("imgurlf", infoTest.getImgURLf());
        model.addAttribute("imgurlb", infoTest.getImgURLb());
        return "notebookinfo";
    }

    @GetMapping("/chatbot")
    public String chatbot(){
        return "chatbot";
    }
}
