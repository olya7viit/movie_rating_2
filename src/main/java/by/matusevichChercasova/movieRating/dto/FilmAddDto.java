package by.matusevichChercasova.movieRating.dto;

import by.matusevichChercasova.movieRating.entity.Actor;
import by.matusevichChercasova.movieRating.entity.Producer;

import javax.validation.constraints.NotNull;
import java.util.Set;

public class FilmAddDto extends AbstractDto {

    @NotNull(message = "Введите название")
    private String name;

    @NotNull(message = "Введите год релиза")
    private String releaseYear;

    @NotNull(message = "Введите жанр")
    private String genre;

    @NotNull(message = "Введите ссылку на фото")
    private String photoPath;

    @NotNull(message = "Введите длительность")
    private String duration;

    @NotNull(message = "Введите аннотацию")
    private String annotation;

    @NotNull(message = "Введите режисера")
    private Long producerId;

    //@NotNull(message = "Введите актеров")
    private Set<Actor> actors;

    public FilmAddDto() {
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public Long getProducerId() {
        return producerId;
    }

    public void setProducerId(Long producerId) {
        this.producerId = producerId;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }
}
