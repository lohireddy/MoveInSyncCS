package com.SpringProjects.MoveInSync.repo;

import com.SpringProjects.MoveInSync.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CabRepo extends JpaRepository<Cab, Integer> {

    @Query(value = "select c.xCoCab from Cab c where c.cabId=:cabId")
    Float getCabLocationX(int cabId);

    @Query(value = "select c.yCoCab from Cab c where c.cabId=:cabId")
    Float getCabLocationY(int cabId);

}
