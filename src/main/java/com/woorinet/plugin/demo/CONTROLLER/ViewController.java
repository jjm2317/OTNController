package com.woorinet.plugin.demo.CONTROLLER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {

    /*
    @GetMapping("/")
    String home() {
        return "index";
    }
    */


    @GetMapping("/")
    String login() { return "login"; }
}
