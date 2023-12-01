package com.SpringProjects.MoveInSync.model;

import com.SpringProjects.MoveInSync.repo.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class RegionDataInit {
    @Autowired
    RegionRepo regionRepo;
    public ArrayList<Region> initRegions(){
        ArrayList<Region> regions = new ArrayList<>();

        int gridSize = 20;
        int regionsPerRow = 10;

        for (int i = 1; i <= regionsPerRow; i++) {
            for (int j = 1; j <= regionsPerRow; j++) {
                int regionId = (i - 1) * regionsPerRow + j;

                Region region = regionRepo.findById(regionId).get();

                // Add neighbors in four directions
                addNeighbor(region, regionId, i - 1, j, regionsPerRow); // Top
                addNeighbor(region, regionId, i + 1, j, regionsPerRow); // Bottom
                addNeighbor(region, regionId, i,  j - 1, regionsPerRow); // Left
                addNeighbor(region, regionId, i, j + 1, regionsPerRow); // Right

                // Add neighbors in four diagonal directions
                addNeighbor(region, regionId, i - 1, j - 1, regionsPerRow); // Top-Left
                addNeighbor(region, regionId, i - 1, j + 1, regionsPerRow); // Top-Right
                addNeighbor(region, regionId, i + 1, j - 1, regionsPerRow); // Bottom-Left
                addNeighbor(region, regionId, i + 1, j + 1, regionsPerRow); // Bottom-Right

                regions.add(region);
            }
        }

        return regions;
    }

    private void addNeighbor(Region region, Integer regionId, int row, int col, int regionsPerRow) {
        if (isValidRegion(row, col, regionsPerRow)) {
            int neighborId = (row - 1) * regionsPerRow + col;
            region.addNeighbor(regionId,neighborId);
        }
    }

    private boolean isValidRegion(int row, int col, int regionsPerRow) {
        return row >= 1 && row <= regionsPerRow && col >= 1 && col <= regionsPerRow;
    }

}
