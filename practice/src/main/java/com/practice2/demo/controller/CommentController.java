package com.practice2.demo.controller;

import com.practice2.demo.errors.PostNotFoundException;
import com.practice2.demo.model.Comment;
import com.practice2.demo.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comment")
@AllArgsConstructor
public class CommentController {
  private final CommentService commentService;

  @PostMapping("comment")
  public Comment createComment(@RequestBody Comment comment) {
    return commentService.createComment(comment);
  }

  @PostMapping("comment-post/{postId}")
  public Comment addCommentToPost(@RequestBody Comment comment, @PathVariable Long postId)
      throws PostNotFoundException {
    return commentService.addCommentToPost(comment, postId);
  }
}
