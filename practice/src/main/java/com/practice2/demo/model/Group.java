package com.practice2.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "groups_table")
public class Group {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Post> posts;

    @OneToMany
    private List<User> users;
}
