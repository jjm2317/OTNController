package com.woorinet.plugin.demo.CONTROLLER;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ViewController {

    @RequestMapping("/")
    String home() {
        return "index";
    }

}
