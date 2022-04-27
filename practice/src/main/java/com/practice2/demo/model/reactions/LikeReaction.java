package com.practice2.demo.model.reactions;

import com.practice2.demo.model.Reaction;

import javax.persistence.Entity;

@Entity
public class LikeReaction extends Reaction {
    public static String react() {
        return "like";
    }
}
