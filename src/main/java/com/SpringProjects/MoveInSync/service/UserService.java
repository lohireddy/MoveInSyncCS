package com.SpringProjects.MoveInSync.service;

import com.SpringProjects.MoveInSync.model.User;
import com.SpringProjects.MoveInSync.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    public void bookCab(){

    }

    public Float getUserLocationX(int userId){
        return userRepo.getUserLocationX(userId);
    }
    public Float getUserLocationY(int userId){
        return userRepo.getUserLocationY(userId);
    }
    public Optional<User> getUserData(int userId) {
        return userRepo.findById(userId);
    }
}
