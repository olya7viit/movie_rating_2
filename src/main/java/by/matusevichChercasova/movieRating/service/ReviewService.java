package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.dto.ReviewDto;

import java.util.List;

public interface ReviewService   {
    boolean saveReview(ReviewDto reviewDto);

    void deleteReview(Long reviewId);

    List<ReviewDto> allReviews(Long idFilm);

    int countReviews();
}
