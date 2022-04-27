package com.practice2.demo.factory;

import com.practice2.demo.model.Reaction;
import com.practice2.demo.model.reactions.AngryReaction;
import com.practice2.demo.model.reactions.HahaReaction;
import com.practice2.demo.model.reactions.LikeReaction;
import org.springframework.stereotype.Component;

@Component
public class ReactionFactory {
    public enum ReactionType {
        HAHA, LIKE, ANGRY
    }
    public static Reaction createReaction(ReactionType reactionType) {
        return switch (reactionType) {
            case HAHA -> new HahaReaction();
            case LIKE -> new LikeReaction();
            case ANGRY -> new AngryReaction();

        };
    }
}
