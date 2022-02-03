package com.films.api.films_api.services;

import java.util.List;
import java.util.Optional;

import com.films.api.films_api.exceptions.DatabaseException;
import com.films.api.films_api.exceptions.ResourceNotFoundException;
import com.films.api.films_api.model.User;
import com.films.api.films_api.persistence.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {

        Optional<User> obj = repository.findById(id);

        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public void deleteById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(User obj, Long id) {
        User entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPassword(obj.getPassword());
        entity.setBornDate(obj.getBornDate());
        entity.setUserImg(obj.getUserImg());
    }

    public User insert(User obj) {

        obj.setPassword(passwordEncoder.encode(obj.getPassword()));
        return repository.save(obj);

    }

    public boolean authenticate(String email, String password) {
        boolean isValid = false;
        User user = repository.findByEmail(email);
        if(user != null){
            isValid = passwordEncoder.matches(password, user.getPassword());
        }
        return isValid;
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
