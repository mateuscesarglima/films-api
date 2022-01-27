package com.films.api.films_api.services;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import com.films.api.films_api.entities.Film;
import com.films.api.films_api.exceptions.DatabaseException;
import com.films.api.films_api.exceptions.InsertException;
import com.films.api.films_api.exceptions.ResourceNotFoundException;
import com.films.api.films_api.repositories.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class FilmServices {

    @Autowired
    private FilmRepository repository;

    public List<Film> findAll() {
        try{
            return repository.findAll();
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    public Film findByid(Long id) {

        Optional<Film> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Film update(Film obj, Long id) {
        Film entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updateData(entity, obj);
        return repository.save(entity);

    }

    private void updateData(Film entity, Film obj) {
        entity.setFilmName(obj.getFilmName());
        entity.setFilmCategory(obj.getFilmCategory());
        entity.setSinopse(obj.getSinopse());
        entity.setImgUrl(obj.getImgUrl());
    }

    public Film insert(Film obj) {
        try {
            return repository.save(obj);
        } catch (ConstraintViolationException e) {
            throw new InsertException(e.getMessage());
        }
    }

}
