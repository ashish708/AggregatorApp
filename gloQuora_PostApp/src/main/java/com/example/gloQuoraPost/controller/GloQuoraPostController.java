package com.example.gloQuoraPost.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gloQuoraPost.model.GloQuoraPost;
import com.example.gloQuoraPost.service.GloQuoraPostService;

@RestController
@RequestMapping("/v1")
public class GloQuoraPostController {

    @Autowired
    private GloQuoraPostService gloQuoraPostService;

    @GetMapping("/getAllPost")
    public ResponseEntity<List<GloQuoraPost>> getAllGloQuoraPost() {
        List<GloQuoraPost> gloQuoraPost = gloQuoraPostService.getAllGloQuoraPost();
        return new ResponseEntity<>(gloQuoraPost, HttpStatus.OK);
    }

    @PostMapping("/addPost")
    public ResponseEntity<GloQuoraPost> addGloQuoraPost(@Valid @RequestBody GloQuoraPost gloQuoraPost) {
        GloQuoraPost newGloQuoraPost = gloQuoraPostService.addGloQuoraPost(gloQuoraPost);
        return new ResponseEntity<>(newGloQuoraPost, HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePost")
    public ResponseEntity<HttpStatus> deleteGloQuoraPost(@PathVariable String id) {
        gloQuoraPostService.deleteGloQuoraPost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/updatePost")
    public ResponseEntity<GloQuoraPost> updateGloQuoraPost(@PathVariable String id, @Valid @RequestBody GloQuoraPost gloQuoraPost) {
        GloQuoraPost updatedGloQuoraPost = gloQuoraPostService.updateGloQuoraPost(id, gloQuoraPost);
        return new ResponseEntity<>(updatedGloQuoraPost, HttpStatus.OK);
    }
}
