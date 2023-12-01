package com.SpringProjects.MoveInSync.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Region {
    @Id
    private int regionId;
    private List<Integer> neighboringRegions;
    private List<Integer> cabsAvailable;

    public void addCab(int cabId){
        cabsAvailable.add(cabId);
    }
    public void removeCab(int cabId){
        cabsAvailable.remove(cabId);
    }

    public void addNeighbor(int regionId, int neighborId) {

    }
    public int getRegionId() {
        return regionId;
    }

    public List<Integer> getCabsAvailable(){
        return cabsAvailable;
    }
}
