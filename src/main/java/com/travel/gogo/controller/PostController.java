package com.travel.gogo.controller;

import com.travel.gogo.entity.Posts;
import com.travel.gogo.request.PostRequest;
import com.travel.gogo.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/post")
@AllArgsConstructor
@CrossOrigin(origins = {"http://gogotravelvn.com/", "http://localhost:3000"})
public class PostController {
    private final PostService postService;

    @PostMapping("/add")
    public ResponseEntity addPost(@RequestBody PostRequest postRequest) {
        postService.addPost(postRequest);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/edit")
    public ResponseEntity editPost(@RequestBody PostRequest postRequest) {
        if(postService.editPost(postRequest)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get-by-id")
    public ResponseEntity<Posts> getById(@RequestParam int id) {
        Posts post = postService.getById(id);
        if(post == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(post);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Posts>> getAll() {
        List<Posts> posts = postService.getAll();
        return ResponseEntity.ok(posts);
    }

    @DeleteMapping("/delete")
    public ResponseEntity deleteById(@RequestParam int id) {
        if(postService.deleteById(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
