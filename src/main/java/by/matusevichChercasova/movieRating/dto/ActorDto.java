package by.matusevichChercasova.movieRating.dto;

import by.matusevichChercasova.movieRating.entity.Film;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class ActorDto extends AbstractDto {

    public ActorDto(){}

    @NotBlank(message = "Введите имя")
    private String name;

    @NotBlank(message = "Введите фамилию")
    private String surname;

    @NotBlank(message = "Введите страну")
    private String country;

    @NotNull(message = "Введите возраст")
    private int age;

    @NotBlank(message = "Введите возраст")
    private String photoPath;

    @NotBlank(message = "Введите биографию")
    private String biography;

    private Set<Film> films;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhotoPath() { return photoPath; }

    public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
