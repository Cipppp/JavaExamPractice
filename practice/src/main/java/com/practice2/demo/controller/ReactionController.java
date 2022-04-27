package com.practice2.demo.controller;

import com.practice2.demo.errors.AlreadyLikedException;
import com.practice2.demo.factory.ReactionFactory;
import com.practice2.demo.model.Reaction;
import com.practice2.demo.repository.ReactionRepository;
import com.practice2.demo.service.ReactionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reaction")
@AllArgsConstructor
public class ReactionController {
  private final ReactionService reactionService;

  @PostMapping("create")
  public Reaction createReaction(@RequestBody Reaction reaction) {
    return reactionService.createReaction(reaction);
  }

  @PostMapping("create/{postId}/{type}/{userId}")
  public Reaction addReactionToPost(
      @RequestBody Reaction reaction,
      @PathVariable("postId") Long postId,
      @PathVariable("type") ReactionFactory.ReactionType type,
      @PathVariable Long userId)
      throws AlreadyLikedException {
    return reactionService.addReactionToPost(reaction, postId, type, userId);
  }
}
