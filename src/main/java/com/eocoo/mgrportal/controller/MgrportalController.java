package com.eocoo.mgrportal.controller;

import com.eocoo.mgrportal.service.OperatorService;
import com.eocoo.mgrportal.service.vo.OperatorVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MgrportalController {

    @Autowired
    private OperatorService operatorService;

    //默认页面
    @RequestMapping("/")
    public String goDefaultPage() {
        return "login";
    }

    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin(Model model) {
        model.addAttribute("welcome", "欢迎登录");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(OperatorVO op, ModelMap map) {
        if(operatorService.hasUser(op)) {
            return "redirect:/index";
        } else {
            return "redirect:/";
        }
    }

    @RequestMapping(value="/index")
    public String index() {
        return "index";
    }
}
