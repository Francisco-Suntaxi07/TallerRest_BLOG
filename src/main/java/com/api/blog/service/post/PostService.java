package com.api.blog.service.post;

import com.api.blog.model.entity.post.PostEntity;
import com.api.blog.model.entity.usuario.UsuarioEntity;
import com.api.blog.model.repository.post.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {

    @Autowired
    private IPostRepository postRepository;

    @Override
    public List<PostEntity> findAllPosts() {
        return (ArrayList<PostEntity>) postRepository.findAll();
    }

    @Override
    public Optional<PostEntity> findPostById(String id) {
        return postRepository.findById(id);
    }

    @Override
    public PostEntity savePost(PostEntity post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePostById(String id) {
        postRepository.deleteById(id);
    }
}

