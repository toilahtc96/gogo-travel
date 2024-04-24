package com.travel.gogo.controller;

import com.travel.gogo.converted.PostConverted;
import com.travel.gogo.entity.Posts;
import com.travel.gogo.request.PostRequest;
import com.travel.gogo.response.PostResponse;
import com.travel.gogo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("public/tour")
@AllArgsConstructor
@CrossOrigin(origins = {"http://gogotravelvn.com/","https://gogotravalvn.com", "http://localhost:3000"})
public class PostPublicController {
    private final PostService postService;
    private final static int NUMBER_TOUR_SHOW = 10;

    @GetMapping("/home-tour")
    public ResponseEntity<List<PostResponse>> getForHome() {
        List<Posts> allTour = postService.getAllActive();
        if(allTour.size()>NUMBER_TOUR_SHOW) {
            allTour = allTour.subList(0,10);
        }
        List<PostResponse> postResponses = allTour.stream().map(
                PostConverted::convertToPostResponse
        ).toList();
        return ResponseEntity.ok(postResponses);
    }
}
