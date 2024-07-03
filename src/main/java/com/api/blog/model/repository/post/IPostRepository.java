package com.api.blog.model.repository.post;

import com.api.blog.model.entity.post.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends CrudRepository<PostEntity, String> {
}

