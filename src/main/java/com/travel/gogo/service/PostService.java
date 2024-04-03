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

        post.setTourCode(postRequest.getTourCode());
        post.setDayInTour(postRequest.getDayInTour());
        post.setTourName(postRequest.getTourName());
        post.setTourSmallInformation(postRequest.getTourSmallInformation());
        post.setPriceOncePerson(postRequest.getPriceOncePerson());
        post.setBenefit(postRequest.getBenefit());
        post.setSpecialInTour(postRequest.getSpecialInTour());
        post.setStatus(postRequest.getStatus());
        post.setMainBackgroundUrl(postRequest.getMainBackgroundUrl());
        post.setContactBackgroundUrl(postRequest.getContactBackgroundUrl());
        post.setInformationUrl(postRequest.getInformationUrl());

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

    public List<Posts> getAllActive() {
        return postRepository.findAllByStatus(Status.ACTIVE);
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
