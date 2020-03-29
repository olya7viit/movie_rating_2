package by.matusevichChercasova.movieRating.dto;

import by.matusevichChercasova.movieRating.entity.Film;

import javax.validation.constraints.NotBlank;
import java.util.Set;

public class ProducerDto extends AbstractDto {

    @NotBlank(message = "need to be null")
    private String name;

    @NotBlank(message = "need to be null")
    private String surname;

    @NotBlank(message = "need to be null")
    private String country;

    @NotBlank(message = "need to be null")
    private String biography;

    @NotBlank(message = "need to be null")
    private String photoPath;

    private Set<Film> films;

    public ProducerDto(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
