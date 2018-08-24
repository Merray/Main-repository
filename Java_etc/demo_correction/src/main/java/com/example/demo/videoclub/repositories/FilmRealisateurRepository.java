package com.example.demo.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.videoclub.model.FilmRealisateur;
import com.example.demo.videoclub.model.FilmRealisateurPK;

public interface FilmRealisateurRepository extends JpaRepository<FilmRealisateur, FilmRealisateurPK> {

}
