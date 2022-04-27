package com.practice2.demo.service;

import com.practice2.demo.model.Post;
import com.practice2.demo.model.User;
import com.practice2.demo.repository.PostRepository;
import com.practice2.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public Post createUserPost(Post post, Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            userOpt.get().getPosts().add(post);
            return postRepository.save(post);
        }
        return null;
    }

    public Post createGroupPost(Post post, Long groupId) {
        Optional<User> groupOpt = userRepository.findById(groupId);
        if (groupOpt.isPresent()) {
            groupOpt.get().getPosts().add(post);
            return postRepository.save(post);
        }
        return null;
    }
}
