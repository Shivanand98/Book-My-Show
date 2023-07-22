package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    @Query(value = "select * from users where mobile =?", nativeQuery = true)
    UserEntity existsbyMobile(String mobile);


}
