package com.eocoo.mgrportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {

    //首页面
    @RequestMapping("")
    public String goDefaultPage() {
        return "article/index";
    }

    @RequestMapping("/search")
    public String search() {
        return "article/index";
    }
}
