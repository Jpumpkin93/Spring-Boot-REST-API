package com.example.jungho.repo;


import com.example.jungho.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJpaRepo extends JpaRepository<Comment, Integer> {
}
