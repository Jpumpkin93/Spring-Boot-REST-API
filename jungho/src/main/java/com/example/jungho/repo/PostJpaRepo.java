package com.example.jungho.repo;

import com.example.jungho.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PostJpaRepo extends JpaRepository<Post, Integer> {

    @Query("SELECT post FROM Post post WHERE post.number LIKE :number")
    @Transactional(readOnly = true)
    Post findByNumber(@Param("number") int number);
}
