package com.example.aryan.watchlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.aryan.watchlist.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {

}
