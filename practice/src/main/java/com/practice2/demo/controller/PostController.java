package com.practice2.demo.controller;

import com.practice2.demo.model.Post;
import com.practice2.demo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("post")
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("create")
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PostMapping("create-user-post/{userId}")
    public Post createUserPost(@RequestBody Post post, @PathVariable Long userId) {
        return postService.createUserPost(post, userId);
    }

    @PostMapping("create-group-post/{groupId}")
    public Post createGroupPost(@RequestBody Post post, @PathVariable Long groupId) {
        return postService.createUserPost(post, groupId);

    }
}
