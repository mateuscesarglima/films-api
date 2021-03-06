package com.films.api.films_api.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.films.api.films_api.model.Film;
import com.films.api.films_api.services.FilmServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@CrossOrigin
@RestController
@RequestMapping(value = "/films")
public class FilmController {

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

    @PostMapping
    public ResponseEntity<Film> insert(@RequestBody @Valid Film obj){
        
        services.insert(obj);

        obj = services.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);


    }

}
