package com.example.demo.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.videoclub.model.Adherent;

public interface AdherentRepository extends JpaRepository<Adherent, Integer> {

}
