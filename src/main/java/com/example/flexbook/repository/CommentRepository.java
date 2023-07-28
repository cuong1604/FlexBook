package com.example.flexbook.repository;

import com.example.flexbook.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("SELECT c from Comment c where c.user.user_id=:user_id")
    List<Comment> commentByUser(int user_id);
}
