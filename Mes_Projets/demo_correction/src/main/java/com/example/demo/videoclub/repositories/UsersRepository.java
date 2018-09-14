package com.example.demo.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.videoclub.model.User;

public interface UsersRepository extends JpaRepository<User, String> {

}
