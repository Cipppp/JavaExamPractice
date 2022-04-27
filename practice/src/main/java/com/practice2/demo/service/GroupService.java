package com.practice2.demo.service;

import com.practice2.demo.model.Group;
import com.practice2.demo.model.Post;
import com.practice2.demo.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;

    public Group createGroup(Group group) {
        return groupRepository.save(group);
    }

    public List<Post> viewAllPostsForGroup(Long groupId) {
        Optional<Group> groupOpt = groupRepository.findById(groupId);
        if (groupOpt.isPresent()) {
            return groupOpt.get().getPosts();
        }
        return null;
    }
}
