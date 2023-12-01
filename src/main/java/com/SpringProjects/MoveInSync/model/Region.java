package com.SpringProjects.MoveInSync.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Id
    private Integer regionId;
    private ArrayList<Integer> neighboringRegions;
    private ArrayList<Integer> cabsAvailable;

    public void addCab(int cabId){
        cabsAvailable.add(cabId);
    }
    public void removeCab(int cabId){
        cabsAvailable.remove(cabId);
    }

    public void addNeighbor(Integer regionId, Integer neighborId) {

    }
}
