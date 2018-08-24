package com.example.demo.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.videoclub.model.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {

}
