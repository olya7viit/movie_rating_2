package by.matusevichChercasova.movieRating.dto;

import by.matusevichChercasova.movieRating.entity.Producer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FilmDto extends AbstractDto {

    @NotBlank(message = "need to be null")
    private String name;

    @NotNull(message = "release year year need to be set")
    private String releaseYear;

    private String genre;

    private String photoPath;

    private String annotation;

    private Producer producer;

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


}
