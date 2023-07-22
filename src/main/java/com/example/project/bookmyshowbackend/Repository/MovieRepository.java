package com.example.project.bookmyshowbackend.Repository;

import com.example.project.bookmyshowbackend.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> { ///Important


        @Query(value = "select * from movies where name = ?",nativeQuery = true)
        MovieEntity existsByName(String name);

}
