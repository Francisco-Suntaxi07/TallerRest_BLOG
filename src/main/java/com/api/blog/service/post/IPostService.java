
package com.api.blog.service.post;

import com.api.blog.model.entity.post.PostEntity;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    public List<PostEntity> findAllPosts();

    public Optional<PostEntity> findPostById(String id);

    public PostEntity savePost(PostEntity post);

    public void deletePostById(String id);
}
