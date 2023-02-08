package com.example.gloQuora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gloQuora.model.Geo;
import com.example.gloQuora.model.UserDetails;

@Repository
public interface GeoRepo extends JpaRepository<Geo, Long>{

	

}
