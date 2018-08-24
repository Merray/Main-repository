package com.example.demo.videoclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.videoclub.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
