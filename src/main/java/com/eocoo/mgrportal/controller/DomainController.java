package com.eocoo.mgrportal.controller;

import com.eocoo.mgrportal.domain.Domain;
import com.eocoo.mgrportal.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/domain")
public class DomainController {

    @Autowired
    private DomainService domainService;

    //首页面
    @RequestMapping("")
    public String goDefaultPage() {
        return "domain/index";
    }

    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "domain/add";
    }

    //Search
    @RequestMapping(value = "/search")
    public String search(ModelMap map) {
        List res = domainService.findAll();
        map.addAttribute("res", res);
        return "domain/index";
    }

    //Add
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postArticle(@ModelAttribute Domain domain) {
        System.out.println("######################## " + domain.getName());
        domainService.addDomain(domain);
        return "redirect:/article/";
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteArticle(@PathVariable Long id) {
        domainService.deleteDomain(id);
        return "redirect:/article/";
    }

    //Put
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putArticle(@ModelAttribute Domain domain) {
        domainService.modDomain(domain);
        return "article/show";
    }

    //Get
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getArticle(@PathVariable Long id, ModelMap map) {
        map.addAttribute("domain", domainService.findById(id));
        return "article/show";
    }
}
