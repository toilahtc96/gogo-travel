package com.travel.gogo.repository;

import com.travel.gogo.constans.Status;
import com.travel.gogo.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts,Integer> {
    List<Posts> findAllByStatus(Status status);
}
