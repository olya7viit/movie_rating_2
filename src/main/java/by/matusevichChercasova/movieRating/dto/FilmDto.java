package by.matusevichChercasova.movieRating.dto;

import by.matusevichChercasova.movieRating.entity.Actor;
import by.matusevichChercasova.movieRating.entity.Producer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class FilmDto extends AbstractDto {

   // @NotBlank(message = "Введите название")
    private String name;

   // @NotBlank(message = "Введите год релиза")
    private String releaseYear;

   // @NotBlank(message = "Введите жанр")
    private String genre;

   // @NotBlank(message = "Введите ссылку на фото")
    private String photoPath;

   // @NotBlank(message = "Введите длительность")
    private String duration;

    //@NotBlank(message = "Введите аннотацию")
    private String annotation;

   // @NotBlank(message = "Введите режисера")
    private Producer producer;

   // @NotBlank(message = "Введите актеров")
    private Set<Actor> actors;

    public FilmDto() { }

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


    public String getDuration() { return duration; }

    public void setDuration(String duration) { this.duration = duration; }
}
