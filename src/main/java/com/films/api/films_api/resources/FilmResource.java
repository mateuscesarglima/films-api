package com.films.api.films_api.resources;

import java.util.List;

import com.films.api.films_api.entities.Film;
import com.films.api.films_api.services.FilmServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/films")
public class FilmResource {

    @Autowired
    private FilmServices services;

    @GetMapping
    public ResponseEntity<List<Film>> findAll(){

        ResponseEntity<List<Film>> response = new ResponseEntity<>(HttpStatus.NO_CONTENT);

        List<Film> obj = services.findAll();

        if(!obj.isEmpty()){
            response = ResponseEntity.ok().body(obj);
        }
        return response;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Film> findById(@PathVariable Long id){

        Film obj = services.findByid(id);

        return ResponseEntity.ok().body(obj);


    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        
        services.delete(id);

        return ResponseEntity.noContent().build();

    }

}
