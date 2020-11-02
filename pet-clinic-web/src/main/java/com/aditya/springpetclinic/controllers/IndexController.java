package com.aditya.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"","/","index.html","index"})
    public String index(){

        System.out.println("dfv  54dfhst 56df  56yhhg");
        return "index";
    }
}
