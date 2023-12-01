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
    public User getUserData(@PathVariable Integer userId){
        Optional<User> user = userService.getUserData(userId);
        return user.get();
    }


}
