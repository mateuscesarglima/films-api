package com.films.api.films_api.config;

import java.time.LocalDate;
import java.util.Arrays;

import com.films.api.films_api.entities.Film;
import com.films.api.films_api.entities.User;
import com.films.api.films_api.entities.enumerated.FilmCategory;
import com.films.api.films_api.repositories.FilmRepository;
import com.films.api.films_api.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"test", "dev"})
public class TestConfig implements CommandLineRunner{
    

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FilmRepository filmRepository;

    @Override
    public void run(String... args) throws Exception {
        
        User u1 = new User(null, "Mateus Cesar", "Mateuscesarglima@gmail.com", "1234" , LocalDate.of(2000, 06, 15) , "");
        User u2 = new User(null, "Mateus Cesar", "Mateuscesarglima@gmail.com", "1234" , LocalDate.of(2000, 06, 15) , "");
        User u3 = new User(null, "Mateus Cesar", "Mateuscesarglima@gmail.com", "1234" , LocalDate.of(2000, 06, 15), "");
        User u4 = new User(null, "Mateus Cesar", "Mateuscesarglima@gmail.com", "1234" , LocalDate.of(2000, 06, 15), "");

        Film f1 = new Film(null, "A volta dos que não foram", "Era uma vez...", FilmCategory.COMEDY, "");
        Film f2 = new Film(null, "Percy jackson", "Percy Jackson (Logan Lerman) é um jovem que enfrenta problemas na escola", FilmCategory.COMEDY, "");
        Film f3 = new Film(null, "Senhor dos aneis", "O Senhor dos Anéis é um livro de alta fantasia, escrito pelo escritor britânico J. R. R. Tolkien. Escrita entre 1937 e 1949, com muitas partes criadas durante a Segunda Guerra Mundial, a saga é uma continuação de O Hobbit", FilmCategory.COMEDY, "");
        
        filmRepository.saveAll(Arrays.asList(f1,f2,f3));

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
    }


}
