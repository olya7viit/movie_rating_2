package by.matusevichChercasova.movieRating.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String country;
    private String biography;

    @Column(name = "photo_path")
    private String photoPath;

    @OneToMany(mappedBy = "producer", fetch = FetchType.EAGER)//cascade = CascadeType.ALL ???????
    private Set<Film> films;

    public Producer() {
    }

    public Producer(String name, String surname, String country, String biography, String photoPath, Set<Film> films) {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.biography = biography;
        this.photoPath = photoPath;
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

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", country='" + country + '\'' +
                ", biography='" + biography + '\'' +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}


