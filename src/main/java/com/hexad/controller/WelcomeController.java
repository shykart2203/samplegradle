package com.hexad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by sureshshamanna on 14/11/15.
 */

@Controller
public class WelcomeController {

    @RequestMapping(name="/welcome" , method = RequestMethod.GET)
    public String welcome(Model model){

        model.addAttribute("name","shyamala");
        return "welcome";
    }


}
