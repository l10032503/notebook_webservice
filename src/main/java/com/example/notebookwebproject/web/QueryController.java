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
public class QueryController {

    @GetMapping("/query")
    public String querypage(){
        return "querypage";
    }

}
