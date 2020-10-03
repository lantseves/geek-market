package com.geekbrains.geekmarket.controllers;

import com.geekbrains.geekmarket.entities.SystemUser;
import com.geekbrains.geekmarket.entities.User;
import com.geekbrains.geekmarket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {
        theModel.addAttribute("systemUser", new SystemUser());
        return "register";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(@Valid @ModelAttribute("systemUser") SystemUser theSystemUser,
                                          BindingResult theBindingResult, Model theModel) {
        String userName = theSystemUser.getUserName();
        if (theBindingResult.hasErrors()) {
            return "register";
        }
        User existing = userService.findByUserName(userName);
        if (existing != null) {
            // theSystemUser.setUserName(null);
            theModel.addAttribute("systemUser", theSystemUser);
            theModel.addAttribute("registrationError", "User name already exists");
            return "register";
        }
        userService.save(theSystemUser);
        return "register-confirmation";
    }
}
