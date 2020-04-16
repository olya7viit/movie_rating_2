package by.matusevichChercasova.movieRating.service.impl;

import by.matusevichChercasova.movieRating.dto.ReviewDto;
import by.matusevichChercasova.movieRating.dto.mapper.ReviewMapper;
import by.matusevichChercasova.movieRating.entity.Review;
import by.matusevichChercasova.movieRating.repository.ReviewRepository;
import by.matusevichChercasova.movieRating.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviesServicerImpl implements ReviewService {

    private final ReviewMapper reviewMapper;
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviesServicerImpl(ReviewMapper reviewMapper, ReviewRepository reviewRepository) {
        this.reviewMapper = reviewMapper;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public boolean saveReview(ReviewDto reviewDto) {
        Review review = reviewMapper.toEntity(reviewDto);
        reviewRepository.save(review);

        return true;
    }
    @Override
    public List<ReviewDto> allReviews( Long idFilm) {
        List<Review> reviews =reviewRepository.findAllByIdFilm(idFilm);

        return reviewMapper.toDtoList(reviews);
    }

    @Override
    public void deleteReview(Long reviewId){

        if (reviewRepository.findById(reviewId).isPresent()) {
            reviewRepository.deleteById(reviewId);
        }
    }
}
