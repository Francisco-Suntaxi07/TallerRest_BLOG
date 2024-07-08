package com.api.blog.controller.post;

import com.api.blog.model.entity.post.PostEntity;
import com.api.blog.service.post.IPostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/post")
public class PostRestController {
    @Autowired
    private IPostService postService;

    private static final Logger logger =
            LoggerFactory.getLogger(PostRestController.class);

    @GetMapping("/all")
    public ResponseEntity<List<PostEntity>> findAllPost(){
        return ResponseEntity.ok().body(postService.findAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<PostEntity>> findPostById(@PathVariable String id){
        return ResponseEntity.ok().body(postService.findPostById(id));
    }

    @PostMapping("/save")
    public ResponseEntity<?> savePost(@RequestBody PostEntity post){
        PostEntity newUps = new PostEntity ();
        try{
            newUps = postService.savePost(post);
            logger.info("se creo el post ");
        } catch (Exception e){
            logger.error("error al registrar: " + e.getMessage());
        }
        return new ResponseEntity<>(newUps, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable String id){
        try {
            postService.deletePostById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al eliminar.");
        }
    }
}
