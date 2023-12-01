package com.SpringProjects.MoveInSync.service;

import com.SpringProjects.MoveInSync.model.Region;
import com.SpringProjects.MoveInSync.repo.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    RegionRepo regionRepo;
    public List<Region> findAll() {
        return regionRepo.findAll();
    }
}
