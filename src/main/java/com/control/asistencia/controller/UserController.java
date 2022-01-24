package com.control.asistencia.controller;

import com.control.asistencia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/userForm")
    public String getUserForm(Model model) {

        model.addAttribute("userList", userService.getAllUsers());

        return "user-form/user-view";
    }
}
