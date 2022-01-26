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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.processing.Messager;
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

    @GetMapping("/editUser/{id}")
    public String getEditUserForm(Model model, @PathVariable(name ="id")Integer id) throws Exception {
        SisUsuario userToEdit = userService.getSisUsuarioById(id);

        model.addAttribute("userCrud", userToEdit);
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("roles",rolRepository.findAll());
        model.addAttribute("editMode","true");
        return "user-form/user-form";
    }

    @PostMapping("/editUser")
    public String updateUser(@Valid @ModelAttribute("userCrud")SisUsuario sisUsuario, BindingResult result, ModelMap model) {
        if(result.hasErrors()){
            model.addAttribute("userCrud",sisUsuario);
            model.addAttribute("editMode","true");

        }else{
            try {
                userService.updateUser(sisUsuario);
                model.addAttribute("userList", userService.getAllUsers());
                return "redirect:/userList";
            }catch (Exception e){
                model.addAttribute("roles",rolRepository.findAll());
                model.addAttribute("userCrud",sisUsuario);
                model.addAttribute("formErrorMessage",e.getMessage());
                model.addAttribute("editMode","true");
            }
        }
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("roles",rolRepository.findAll());
        return "user-form/user-form";
    }


    @GetMapping("/editUser/cancel")
    public String cancelEditUser(ModelMap model) {
        return "redirect:/userList";
    }



    @GetMapping("/deleteUser/{id}")
    public String deleteUser(Model model, @PathVariable(name="id") Integer id) {
        try {

            userService.deleteUser(id);



        } catch (Exception e) {
            model.addAttribute("listErrorMessage",e.getMessage());
        }
        return getUserForm(model);
    }

    @GetMapping("/insertarUser/insertar")
    public String insertUser(ModelMap model) {
        return "redirect:/user";
    }


}
