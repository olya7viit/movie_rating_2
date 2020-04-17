package by.matusevichChercasova.movieRating.dto;

import by.matusevichChercasova.movieRating.entity.Actor;
import by.matusevichChercasova.movieRating.entity.Producer;

import java.util.Set;

public class FilmBookmarkDto extends AbstractDto {

    private String name;
    private String releaseYear;
    private String genre;
    private String photoPath;
    private String duration;
    private String annotation;
    private Producer producer;
    private Set<Actor> actors;
    private boolean InBookmark;

    public FilmBookmarkDto(){}

    public FilmBookmarkDto(String name, String releaseYear, String genre,
                           String photoPath, String duration, String annotation,
                           Producer producer, Set<Actor> actors, boolean inBookmark) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.photoPath = photoPath;
        this.duration = duration;
        this.annotation = annotation;
        this.producer = producer;
        this.actors = actors;
        InBookmark = inBookmark;
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

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public boolean isInBookmark() {
        return InBookmark;
    }

    public void setInBookmark(boolean inBookmark) {
        InBookmark = inBookmark;
    }
}
