package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.FilmRealisateur;
import com.example.demo.model.FilmRealisateurPk;

public interface FilmRealisateurRepository extends JpaRepository<FilmRealisateur, FilmRealisateurPk>{

}
