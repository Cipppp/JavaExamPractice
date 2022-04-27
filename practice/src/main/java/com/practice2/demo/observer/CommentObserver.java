package com.practice2.demo.observer;

import com.practice2.demo.model.Comment;
import com.practice2.demo.model.Post;
import org.springframework.stereotype.Component;

@Component
public class CommentObserver {
    private Post post;

    public void subscribe(Post post) {
        this.post = post;
    }
    
    public void update(Comment comment) {
        if (post != null) {
            System.out.println("Comment : " + comment + " has been added to post.");
        }
    }
}
