package com.practice2.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Post post;

    @OneToOne
    private User user;
}
