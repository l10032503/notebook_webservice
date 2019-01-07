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

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/notebookinfo/{ID}")
    public String notebookinfo(@PathVariable int ID, final Model model){
        infoTEST infoTest = infoTestMapper.findinfotestID(ID);
        model.addAttribute("id", infoTest.getID());
        model.addAttribute("model", infoTest.getModel());
        model.addAttribute("imgurlf", infoTest.getImgURLf());
        model.addAttribute("imgurlb", infoTest.getImgURLb());
        model.addAttribute("brand", infoTest.getBrand());
        model.addAttribute("price", infoTest.getPrice());
        model.addAttribute("pricestring", infoTest.getPriceString());
        model.addAttribute("sizeint", infoTest.getSizeINT());
        model.addAttribute("weight", infoTest.getWeight());
        model.addAttribute("weightstring", infoTest.getWeightString());
        model.addAttribute("thick", infoTest.getThick());
        model.addAttribute("resolution", infoTest.getResolution());
        model.addAttribute("cpumanufact", infoTest.getCPUManufact());
        model.addAttribute("cpukind", infoTest.getCPUKind());
        model.addAttribute("cpucode", infoTest.getCPUCode());
        model.addAttribute("cpunumber", infoTest.getCPUNumber());
        model.addAttribute("cpucore", infoTest.getCPUCore());
        //
        model.addAttribute("memorytype", infoTest.getMemoryType());
        model.addAttribute("memorysize", infoTest.getMemorySize());
        model.addAttribute("gpumanufact", infoTest.getGPUManufact());
        model.addAttribute("gpukind", infoTest.getGPUKind());
        model.addAttribute("hddsize", infoTest.getHDDSize());
        model.addAttribute("ssd", infoTest.getSSD());
        model.addAttribute("ssdsize", infoTest.getSSDSize());
        model.addAttribute("os", infoTest.getOS());
        model.addAttribute("afterservice", infoTest.getAfterService());
        //
        model.addAttribute("networkstring", infoTest.getNetworkString());
        model.addAttribute("videostring", infoTest.getVideoString());
        model.addAttribute("terminalstring", infoTest.getTerminalString());
        model.addAttribute("keyboardstring", infoTest.getKeyboardString());
        model.addAttribute("securitystring", infoTest.getSecurityString());
        return "notebookinfo";
    }

    @GetMapping("/chatbot")
    public String chatbot(){
        return "chatbot";
    }
}
