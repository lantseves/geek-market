package com.geekbrains.geekmarket.controllers;

import com.geekbrains.geekmarket.entities.Role;
import com.geekbrains.geekmarket.entities.SystemUser;
import com.geekbrains.geekmarket.entities.User;
import com.geekbrains.geekmarket.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/role")
public class RoleController {

    private RoleService roleService ;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/showAddForm")
    public String showMyLoginPage(Model theModel) {
        theModel.addAttribute("role", new Role());
        return "role";
    }

    @PostMapping("/processAddForm")
    public String processRegistrationForm(@Valid @ModelAttribute("role") Role role,
                                          BindingResult theBindingResult, Model theModel) {
        String roleName = role.getName() ;
        if (theBindingResult.hasErrors()) {
            return "role";
        }
        Role existing = roleService.findRoleByName(roleName) ;
        if (existing != null) {
            theModel.addAttribute("role", role);
            theModel.addAttribute("registrationError", "Role name already exists");
            return "role";
        }
        roleService.addRole(role);
        return "role-confirmation";
    }
}
