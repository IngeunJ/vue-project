package com.project.web.contoller;

import org.springframework.stereotype.Controller;

/**
 * HomeController
 */
@Controller
public class HomeController {

    public String index(){

        return "index";
    }
    
}