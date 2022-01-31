package com.films.api.films_api.persistence;

import com.films.api.films_api.model.Film;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
    
}
