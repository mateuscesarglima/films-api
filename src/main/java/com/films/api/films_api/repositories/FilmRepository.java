package com.films.api.films_api.repositories;

import com.films.api.films_api.entities.Film;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
    
}
