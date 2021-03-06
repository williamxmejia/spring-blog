package com.codeup.springblog.repositories;

import com.codeup.springblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findById(long id);

    Post findFirstByTitle(String title);

}
