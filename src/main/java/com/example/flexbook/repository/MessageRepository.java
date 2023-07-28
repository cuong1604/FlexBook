package com.example.flexbook.repository;

import com.example.flexbook.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("SELECT m from Message m where m.sender.user_id=:user_id")
    List<Message> messageFromUser(int user_id);

    @Query("SELECT m from Message m where m.receiver.user_id=:user_id")
    List<Message> messageToUser(int user_id);
}
