package com.practice2.demo.service;

import com.practice2.demo.errors.AlreadyLikedException;
import com.practice2.demo.factory.ReactionFactory;
import com.practice2.demo.model.Post;
import com.practice2.demo.model.Reaction;
import com.practice2.demo.model.User;
import com.practice2.demo.repository.PostRepository;
import com.practice2.demo.repository.ReactionRepository;
import com.practice2.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ReactionService {
  private final ReactionRepository reactionRepository;
  private final PostRepository postRepository;
  private final UserRepository userRepository;

  public Reaction createReaction(Reaction reaction) {
    return reactionRepository.save(reaction);
  }

  public Reaction addReactionToPost(
      Reaction reaction, Long postId, ReactionFactory.ReactionType type, Long userId)
      throws AlreadyLikedException {
    Optional<Post> postOpt = postRepository.findById(postId);
    Optional<User> userOpt = userRepository.findById(userId);

    if (postOpt.isPresent() && userOpt.isPresent()) {
      Reaction react = ReactionFactory.createReaction(type);
      react.addUser(userOpt.get());
      postOpt.get().getReacts().add(react);
      return reactionRepository.save(react);
    }
    return null;
  }
}
