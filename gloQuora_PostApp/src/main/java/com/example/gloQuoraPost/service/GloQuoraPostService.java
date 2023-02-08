package com.example.gloQuoraPost.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gloQuoraPost.exception.ResourceNotFoundException;
import com.example.gloQuoraPost.model.GloQuoraPost;
import com.example.gloQuoraPost.repository.GloQuoraPostRepository;

@Service
public class GloQuoraPostService {

    @Autowired
    private GloQuoraPostRepository gloQuoraPostRepository;

    public List<GloQuoraPost> getAllGloQuoraPost() {
        return gloQuoraPostRepository.findAll();
    }

    public GloQuoraPost addGloQuoraPost(GloQuoraPost gloQuoraPost) {
        return gloQuoraPostRepository.save(gloQuoraPost);
    }

    public void deleteGloQuoraPost(String id) {
        gloQuoraPostRepository.deleteById(id);
    }

    public GloQuoraPost updateGloQuoraPost(String id, GloQuoraPost gloQuoraPost) {
        GloQuoraPost existingPost = gloQuoraPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GloQuora post not found with id " + id));
        existingPost.setTitle(gloQuoraPost.getTitle());
        existingPost.setBody(gloQuoraPost.getBody());
        return gloQuoraPostRepository.save(existingPost);
    }
}
