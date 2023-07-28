package com.example.flexbook.repository;

import com.example.flexbook.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Integer> {
    @Query("SELECT l from Like l where l.user.user_id=:user_id")
    List<Like> likesByUser(int user_id);
}
