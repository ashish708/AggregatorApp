package com.example.gloQuoraPost.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.gloQuoraPost.model.GloQuoraPost;

public interface GloQuoraPostRepository extends MongoRepository<GloQuoraPost, String> {
}
