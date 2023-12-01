package com.SpringProjects.MoveInSync.repo;

import com.SpringProjects.MoveInSync.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    @Query(value = "select u.xCoUser from User u where u.userId=:userId")
    Float getUserLocationX(int userId);

    @Query(value = "select u.yCoUser from User u where u.userId=:userId")
    Float getUserLocationY(int userId);
}
