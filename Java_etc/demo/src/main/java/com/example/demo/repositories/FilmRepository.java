package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Film;

public interface FilmRepository extends JpaRepository<Film, Integer>{

}
