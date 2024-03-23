package com.travel.gogo.service;

import com.travel.gogo.constans.Status;
import com.travel.gogo.converted.PostConverted;
import com.travel.gogo.entity.Posts;
import com.travel.gogo.repository.PostRepository;
import com.travel.gogo.request.PostRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void addPost(PostRequest userRequest) {
        Posts post = PostConverted.convertPostRequest(userRequest);
        post.setCreatedTime(LocalDateTime.now());
        postRepository.save(post);
    }

    public boolean editPost(PostRequest postRequest) {
        if (postRequest.getId() == null) {
            return false;
        }
        int id = postRequest.getId();
        Posts post = postRepository.findById(id).orElse(null);
        if (post == null) {
            return false;
        }
        post.setUserId(postRequest.getUserId());
        post.setAddressId(postRequest.getAddressId());
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setThumbnail(postRequest.getThumbnail());
        post.setThumbnail(postRequest.getContentImage());
        post.setStatus(postRequest.getStatus());
        try {
            postRepository.save(post);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Posts getById(int id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Posts> getAll() {
        return postRepository.findAll();
    }

    public boolean deleteById(int id) {

        Posts user = postRepository.findById(id).orElse(null);
        if (user == null) {
            return false;
        }
        user.setStatus(Status.BLOCK);
        try {
            postRepository.save(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
