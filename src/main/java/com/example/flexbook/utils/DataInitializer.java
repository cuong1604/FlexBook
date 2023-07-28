package com.example.flexbook.utils;

import com.example.flexbook.model.Message;
import com.example.flexbook.model.Post;
import com.example.flexbook.model.User;
import com.example.flexbook.repository.MessageRepository;
import com.example.flexbook.repository.PostRepository;
import com.example.flexbook.repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;

@Configuration
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final Faker faker;
    private final PostRepository postRepository;
    private final MessageRepository messageRepository;

    public DataInitializer(UserRepository userRepository, PostRepository postRepository, MessageRepository messageRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.messageRepository = messageRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUser_id(i + 1);
            user.setUsername(faker.name().username());
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password());
            user.setProfile_picture(faker.internet().image());
            user.setBio(faker.lorem().sentence());
            user.setCreated_at(new Timestamp(System.currentTimeMillis()));
            user.setUpdated_at(new Timestamp(System.currentTimeMillis()));
            userRepository.save(user);
        }

        for(int i = 0; i <10; i++){
            Post post = new Post();
            post.setPost_id(i+1);
            post.setContent(faker.lorem().sentence());
            post.setPost_image(faker.internet().image());
            post.setCreated_at(new Timestamp(System.currentTimeMillis()));
            post.setUpdated_at(new Timestamp(System.currentTimeMillis()));
            postRepository.save(post);
        }
        
    }
}
