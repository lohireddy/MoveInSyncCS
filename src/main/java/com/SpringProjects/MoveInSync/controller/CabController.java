package com.SpringProjects.MoveInSync.controller;

import com.SpringProjects.MoveInSync.model.Cab;
import com.SpringProjects.MoveInSync.model.Region;
import com.SpringProjects.MoveInSync.model.User;
import com.SpringProjects.MoveInSync.service.CabService;
import com.SpringProjects.MoveInSync.service.RegionService;
import com.SpringProjects.MoveInSync.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public Optional<Cab> getCabData(@PathVariable int cabId){
        return cabService.getCabData(cabId);
    }
    @PostMapping("/bookCab/{userId}")
    public ResponseEntity<String> bookCab(@PathVariable int userId){
        Optional<User> user = userService.getUserData(userId);
        if(user.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Float userLocationX = userService.getUserLocationX(userId);
        Float userLocationY = userService.getUserLocationY(userId);
        int regionId = getRegionId(userLocationX,userLocationY);
        List<Region> regionList = regionService.findAll();
        bfs(userLocationX,userLocationY,regionId,regionList);
        return new ResponseEntity<>("Succesfully boooked your cab", HttpStatus.OK);
    }

    private void bfs(Float userLocationX, Float userLocationY, int regionId, List<Region> regionList) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(regionId);
        visited.add(regionId);

        while (!queue.isEmpty()){
            int currRegionId = queue.poll();
            try {

                Region currentRegion = getRegionById(currRegionId,regionList);
                assert currentRegion != null;


                    if (currentRegion.getCabsAvailable()!=null){
                        int nearestCabId = getNearestCab(userLocationX,userLocationY,currentRegion.getCabsAvailable());
                    }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private int getNearestCab(Float userLocationX, Float userLocationY, List<Integer> cabsAvailable) {
        int nearestCabId = cabsAvailable.get(0);
        Float minDistance = calculateDistance(userLocationX,userLocationY,getCabLocationX(nearestCabId),getCabLocationY(nearestCabId));
        for (int cabId: cabsAvailable){
            Float distance = calculateDistance(userLocationX,userLocationY,getCabLocationX(cabId),getCabLocationY(cabId));
            if(distance<minDistance){
                minDistance = distance;
                nearestCabId = cabId;
            }
        }
        return nearestCabId;
    }

    private Float calculateDistance(Float userLocationX, Float userLocationY, Float cabLocationX, Float cabLocationY) {
        return (float) Math.sqrt(Math.pow(cabLocationX - userLocationX, 2) + Math.pow(cabLocationY - userLocationY, 2));
    }

    private Float getCabLocationX(int cabId) {
        return cabService.getCabLocationX(cabId);
    }
    private Float getCabLocationY(int cabId) {
        return cabService.getCabLocationY(cabId);
    }

    private Region getRegionById(int currRegionId, List<Region> regionList) {
        for (Region region : regionList) {
            if (region.getRegionId() == currRegionId) {
                return region;
            }
        }
        return null;
    }

    public int getRegionId(Float userLocationX, Float userLocationY) {
        int gridSize = 20;
        int regionsPerRow = gridSize/2;

        int regionX = (int) Math.ceil(userLocationX/2);
        int regionY = (int) Math.ceil(userLocationY/2);

        return (regionY-1)*regionsPerRow + regionX;
    }

}
