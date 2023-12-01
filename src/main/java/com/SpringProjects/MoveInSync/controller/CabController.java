package com.SpringProjects.MoveInSync.controller;

import com.SpringProjects.MoveInSync.model.Cab;
import com.SpringProjects.MoveInSync.model.Region;
import com.SpringProjects.MoveInSync.model.User;
import com.SpringProjects.MoveInSync.service.CabService;
import com.SpringProjects.MoveInSync.service.RegionService;
import com.SpringProjects.MoveInSync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cab")
public class CabController {

    @Autowired
    CabService cabService;
    @Autowired
    UserService userService;
    @Autowired
    RegionService regionService;
    @GetMapping("/getCabData/{cabId}")
    public Cab getCabData(@PathVariable Integer cabId){
        Optional<Cab> cab = cabService.getCabData(cabId);
        return cab.get();
    }
    @PostMapping("/bookCab/{userId}")
    public ResponseEntity<String> bookCab(@PathVariable Integer userId){
        Optional<User> user = userService.getUserData(userId);
        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Float userLocationX = userService.getUserLocationX(userId);
        Float userLocationY = userService.getUserLocationY(userId);
        Integer regionId = getRegionId(userLocationX,userLocationY);
        List<Region> regionList = regionService.findAll();
        bfs(userLocationX,userLocationY,regionId);
        return new ResponseEntity<>("ok ok", HttpStatus.OK);
    }

    private Integer getRegionId(Float userLocationX, Float userLocationY) {
        int gridSize = 20;
        int regionsPerRow = gridSize/2;

        int regionX = (int) Math.ceil(userLocationX/2);
        int regionY = (int) Math.ceil(userLocationY/2);

        return (regionY-1)*regionsPerRow + regionX;
    }

}
