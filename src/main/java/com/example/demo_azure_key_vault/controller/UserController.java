package com.example.demo_azure_key_vault.controller;

import com.example.demo_azure_key_vault.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/mysql")
    public String GetUser() {
        return userService.Sel(1).toString();
    }
}
