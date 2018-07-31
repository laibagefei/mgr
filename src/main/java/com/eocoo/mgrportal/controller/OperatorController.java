package com.eocoo.mgrportal.controller;

import com.eocoo.mgrportal.domain.Operator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OperatorController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        Operator op = new Operator();
        model.addAttribute("op", op);
        return "hello";
    }


}
