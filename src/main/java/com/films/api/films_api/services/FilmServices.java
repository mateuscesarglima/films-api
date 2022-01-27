package com.films.api.films_api.services;

import java.util.List;
import java.util.Optional;

import com.films.api.films_api.entities.Film;
import com.films.api.films_api.exceptions.ResourceNotFoundException;
import com.films.api.films_api.repositories.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServices {

    @Autowired
    private FilmRepository repository;

    public List<Film> findAll() {
        return repository.findAll();
    }

    public Film findByid(Long id) {

        Optional<Film> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
