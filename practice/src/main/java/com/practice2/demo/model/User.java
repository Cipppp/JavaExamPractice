package com.practice2.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    @ManyToOne
    private Group groups;

    @OneToMany
    private List<Post> posts;
}
