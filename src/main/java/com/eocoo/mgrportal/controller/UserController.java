package com.eocoo.mgrportal.controller;

import com.eocoo.mgrportal.controller.vo.UserVO;
import com.eocoo.mgrportal.domain.User;
import com.eocoo.mgrportal.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @RequestMapping("/toAddPage")
    public String toAddPage() {
        return "user/add";
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
    public String postUser(@ModelAttribute UserVO userVo, @RequestParam("avatar") MultipartFile picFile) {
        try {
            String filename = picFile.getOriginalFilename();
            SimpleDateFormat sdf = new SimpleDateFormat("yyMMddhhmmss");
            String newFileName = sdf.format(new Date()) + filename.substring(filename.lastIndexOf("."));
            System.out.println(">>>>>>>>>>>>>>>. file: " + newFileName);
            //上传图片
            String path = "E:\\work\\mgr-portal\\src\\main\\resources\\static\\pic\\" + newFileName;
            picFile.transferTo(new File(path));
            User user = new User();
            BeanUtils.copyProperties(userVo, user);
            user.setAvatar("/pic/" + newFileName);
            userService.addUser(user);
            return "redirect:/user/";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
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
