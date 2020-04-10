package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.dto.RatingDto;

public interface RatingService {
    boolean saveRating(RatingDto ratingDto);

    long isRatingExists(RatingDto ratingDto);

    void updateRating (RatingDto ratingDto);
}
