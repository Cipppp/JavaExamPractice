package com.practice2.demo.controller;

import com.practice2.demo.model.Group;
import com.practice2.demo.model.Post;
import com.practice2.demo.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("group")
@AllArgsConstructor
public class GroupController {
    private final GroupService groupService;

    @PostMapping("create")
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }
    @GetMapping("view-all-posts/{groupId}")
    public List<Post> viewAllPostsForGroup(@PathVariable Long groupId) {
        return groupService.viewAllPostsForGroup(groupId);
    }
}
