package com.SpringProjects.MoveInSync.repo;

import com.SpringProjects.MoveInSync.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepo extends JpaRepository<Region, Integer> {

}
