package com.films.api.films_api.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.films.api.films_api.entities.enumerated.FilmCategory;

@Entity
@Table(name = "tb_film")
public class Film implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "The user password cannot be empty")
    @NotNull
    private String filmName;

    @NotEmpty(message = "The user password cannot be empty")
    @NotNull
    private String sinopse;

    @NotEmpty(message = "The user password cannot be empty")
    @NotNull
    @Enumerated(EnumType.STRING)
    private FilmCategory filmCategory;

    private String imgUrl;

    public Film() {
    }

    public Film(Long id, String filmName, String sinopse, FilmCategory filmCategory, String imgUrl) {
        this.id = id;
        this.filmName = filmName;
        this.sinopse = sinopse;
        this.filmCategory = filmCategory;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public FilmCategory getFilmCategory() {
        return filmCategory;
    }

    public void setFilmCategory(FilmCategory filmCategory) {
        this.filmCategory = filmCategory;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Film other = (Film) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
