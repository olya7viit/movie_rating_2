package by.matusevichChercasova.movieRating.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "release_year")
    @Size(min=4, max=4)
    private String releaseYear;

    private String genre;

    @Column(name = "photo_path")
    private String photoPath;

    private String duration;

    private String annotation;

    @ManyToOne(fetch = FetchType.EAGER)
    private Producer producer;

   // @ManyToMany(mappedBy = "films")
   @ManyToMany(fetch = FetchType.EAGER)
    private Set<Actor> actors;

    public Film(){}

    public Film(String name, @Size(min = 4, max = 4) String releaseYear, String genre, String photoPath, String duration, String annotation, Producer producer) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.photoPath = photoPath;
        this.duration = duration;
        this.annotation = annotation;
        this.producer = producer;
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

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id) &&
                Objects.equals(name, film.name) &&
                Objects.equals(releaseYear, film.releaseYear) &&
                Objects.equals(genre, film.genre) &&
                Objects.equals(photoPath, film.photoPath) &&
                Objects.equals(duration, film.duration) &&
                Objects.equals(annotation, film.annotation) &&
                Objects.equals(producer, film.producer) &&
                Objects.equals(actors, film.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseYear, genre, photoPath, duration, annotation, producer, actors);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", genre='" + genre + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", duration='" + duration + '\'' +
                ", annotation='" + annotation + '\'' +
                ", producer=" + producer +
                ", actors=" + actors +
                '}';
    }
}
