package com.SpringProjects.MoveInSync.service;

import com.SpringProjects.MoveInSync.model.Cab;
import com.SpringProjects.MoveInSync.model.User;
import com.SpringProjects.MoveInSync.repo.CabRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CabService{
    @Autowired
    CabRepo cabRepo;

    public Optional<Cab> getCabData(int cabId) {
        Optional<Cab> cab = cabRepo.findById(cabId);
        return cab;
    }

    public Float getCabLocationX(int cabId) {
        return cabRepo.getCabLocationX(cabId);
    }

    public Float getCabLocationY(int cabId) {
        return cabRepo.getCabLocationY(cabId);
    }
}
