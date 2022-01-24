package com.control.asistencia.controller;

import com.control.asistencia.entity.SisUsuario;
import com.control.asistencia.repository.RolRepository;
import com.control.asistencia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RolRepository rolRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/userList")
    public String getUserForm(Model model) {

        model.addAttribute("userList", userService.getAllUsers());

        return "user-form/user-view";
    }

    @GetMapping("/user")
    public String getUserForm1(Model model) {
        model.addAttribute("userCrud", new SisUsuario());
        model.addAttribute("roles",rolRepository.findAll());
        return "user-form/user-form";
    }

}
