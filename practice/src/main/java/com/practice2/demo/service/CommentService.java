package com.practice2.demo.service;

import com.practice2.demo.errors.PostNotFoundException;
import com.practice2.demo.model.Comment;
import com.practice2.demo.model.Post;
import com.practice2.demo.repository.CommentRepository;
import com.practice2.demo.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {
  private final CommentRepository commentRepository;
  private final PostRepository postRepository;

  public Comment createComment(Comment comment) {
    return commentRepository.save(comment);
  }

  public Comment addCommentToPost(Comment comment, Long postId) throws PostNotFoundException {

    Optional<Post> postOpt = postRepository.findById(postId);
    if (postOpt.isPresent()) {
      postOpt.get().addComment(comment);
      postRepository.save(postOpt.get());
      return comment;
    } else {
      throw new PostNotFoundException("Post not found !");
    }
  }
}
