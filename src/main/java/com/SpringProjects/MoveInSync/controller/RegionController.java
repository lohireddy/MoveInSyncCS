package com.SpringProjects.MoveInSync.controller;

import com.SpringProjects.MoveInSync.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/region")
public class RegionController {

    @Autowired
    RegionService regionService;

    public void updateRegion(Integer regionId){

    }
    public void addCabInRegion(Integer cabId){

    }
}
