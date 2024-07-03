package com.api.blog.controller.post;

import com.api.blog.model.entity.post.PostEntity;
import com.api.blog.service.post.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostRestController {

    @Autowired
    private IPostService postService;

    @GetMapping
    public List<PostEntity> findAll() {
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public PostEntity findById(@PathVariable String id) {
        return postService.findPostById(id).orElse(null);
    }

    @PostMapping
    public PostEntity save(@RequestBody PostEntity post) {
        return postService.savePost(post);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        postService.deletePostById(id);
    }
}
