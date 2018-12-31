package com.example.notebookwebproject.web;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    @GetMapping("/")
    public String main(){
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
}
