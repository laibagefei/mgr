package com.eocoo.mgrportal.controller;

import com.eocoo.mgrportal.domain.Article;
import com.eocoo.mgrportal.domain.ArticleRepository;
import com.eocoo.mgrportal.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //首页面
    @RequestMapping("")
    public String goDefaultPage() {
        return "article/index";
    }

    //Search
    @RequestMapping("/search")
    public String search(ModelMap map) {
        List<Article> res = articleService.findAll();
        map.addAttribute("res", res);
        return "article/index";
    }

    //Add
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postArticle(@ModelAttribute Article article) {
        articleService.addArticle(article);
        return "redirect:/article/";
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteArticle(@PathVariable Long id) {
        articleService.deleteArticle(id);
        return "redirect:/article/";
    }

    //Put
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putArticle(@ModelAttribute Article article) {
        articleService.modArticle(article);
        return "article/show";
    }

    //Get
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getArticle(@PathVariable Long id, ModelMap map) {
        map.addAttribute("article", articleService.findById(id));
        return "article/show";
    }

}
