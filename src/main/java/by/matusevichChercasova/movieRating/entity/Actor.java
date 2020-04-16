package by.matusevichChercasova.movieRating.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "actor")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String country;
    private String photoPath;
    private int age;
    private String biography;

    //@ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany(mappedBy = "actors")
    private Set<Film> films;

    public Actor(){}

    public Actor(String name, String surname, String country, String photoPath, int age, String biography, Set<Film> films) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.photoPath = photoPath;
        this.age = age;
        this.biography = biography;
        this.films = films;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
    public String getPhotoPath() { return photoPath; }

    public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", age=" + age +
                ", biography='" + biography + '\'' +
                ", films=" + films +
                '}';
    }
}
