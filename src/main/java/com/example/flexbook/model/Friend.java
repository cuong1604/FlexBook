package com.example.flexbook.model;

import com.example.flexbook.enums.FriendStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Table(name="friends")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int friend_id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id1", nullable = false)
    private User user1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id2", nullable = false)
    private User user2;
    private FriendStatus status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "action_user_id", nullable = false)
    private User actionUser;
    private Timestamp created_at;
    private Timestamp updated_at;
}
