package com.example.notebookwebproject.web;

import com.example.notebookwebproject.SQLTEST.infoTEST;
import com.example.notebookwebproject.SQLTEST.infoTESTMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ResultController {

    @GetMapping("/result")
    public String result(Model model){
        model.addAttribute("result_txt","result_txt");
        return "result";
    }
}
