package com.lyy.client.controller;

import com.lyy.client.remoteservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUserCount")
    public String getUserCount() {
        Integer userCount = userService.getUserCount();
        return userCount.toString();
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo() {
        return userService.getUserInfo(1);
    }

    @GetMapping("/addUser")
    public String addUser() {
        Integer userId = userService.addUser("name", "abc@gmail.com", 16, 0, "Garden School");
        return userId.toString();
    }

}