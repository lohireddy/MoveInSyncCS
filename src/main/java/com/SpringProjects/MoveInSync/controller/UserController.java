package com.SpringProjects.MoveInSync.controller;

import com.SpringProjects.MoveInSync.model.User;
import com.SpringProjects.MoveInSync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getUserData/{userId}")
    public Optional<User> getUserData(@PathVariable int userId){
        return userService.getUserData(userId);
    }

    @GetMapping("/getUserLocationX/{userId}")
    public Float getUserLocationX(@PathVariable int userId){
        return userService.getUserLocationX(userId);
    }


}
