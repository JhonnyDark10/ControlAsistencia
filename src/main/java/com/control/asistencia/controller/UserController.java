package com.control.asistencia.controller;

import com.control.asistencia.entity.SisUsuario;
import com.control.asistencia.repository.RolRepository;
import com.control.asistencia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @PostMapping("/user")
    public String createUser(@Valid @ModelAttribute("userCrud")SisUsuario sisUsuario, BindingResult result, ModelMap model){
    if(result.hasErrors()){
        model.addAttribute("userCrud",sisUsuario);
        System.out.println("jhonny <aqi entro en error");
    }else{
        try {

            System.out.println("flores <aqi entro a insertar");
            userService.createUser(sisUsuario);
            model.addAttribute("userList", userService.getAllUsers());
            return "redirect:/userList";
        }catch (Exception e){
            System.out.println("jhonny <aqi entro en error 22222");
            model.addAttribute("formErrorMessage",e.getMessage());
        }
    }

        model.addAttribute("roles",rolRepository.findAll());
        return "user-form/user-form";
    }

}
