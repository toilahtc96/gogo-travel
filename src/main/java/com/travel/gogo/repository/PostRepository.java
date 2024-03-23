package com.travel.gogo.repository;

import com.travel.gogo.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts,Integer> {
}
