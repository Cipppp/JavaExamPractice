package com.practice2.demo.model;

import com.practice2.demo.errors.AlreadyLikedException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Reaction {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private User user;

    @ManyToOne
    private Post post;

    public void addUser(User user) throws AlreadyLikedException {
        if (user != null) {
            throw new AlreadyLikedException("User Already Reacted !");
        } else {
            this.user = user;
        }
    }
}
