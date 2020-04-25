package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.dto.RatingDto;
import by.matusevichChercasova.movieRating.entity.Film;

import java.util.List;

public interface RatingService {
    boolean saveRating(RatingDto ratingDto);

    long isRatingExists(RatingDto ratingDto);

    void updateRating (RatingDto ratingDto);

    double oneFilmRating(Long idFilm);
}
