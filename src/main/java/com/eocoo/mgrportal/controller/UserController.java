package com.eocoo.mgrportal.controller;

import com.eocoo.mgrportal.domain.User;
import com.eocoo.mgrportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("")
    public String home() {
        return "user/index";
    }

    //Search
    @RequestMapping("/search")
    public String search(ModelMap map) {
        List<User> res = userService.findAll();
        map.addAttribute("res", res);
        return "user/index";
    }

    //Add
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/user/";
    }

    //Delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/user/";
    }

    //Put
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@ModelAttribute User user) {
        userService.modUser(user);
        return "user/show";
    }

    //Get
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable Long id, ModelMap map) {
        map.addAttribute("user", userService.findById(id));
        return "user/show";
    }
}
