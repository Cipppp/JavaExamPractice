package com.practice2.demo.model;

import com.practice2.demo.observer.CommentObserver;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "social_posts")
public class Post {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @OneToOne
    private User user;
    
    @OneToMany
    private List<Comment> comments;
    
    @OneToMany
    private List<Reaction> reacts;

    @Transient
    private CommentObserver commentObserver;

    public void addComment(Comment comment) {
        comments.add(comment);
        commentObserver.update(comment);
    }
}
