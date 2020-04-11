package by.matusevichChercasova.movieRating.dto.mapper;


import by.matusevichChercasova.movieRating.dto.ReviewDto;
import by.matusevichChercasova.movieRating.entity.Review;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewMapper implements Mapper<ReviewDto, Review>{

    @Override
    public Review toEntity(ReviewDto reviewDto) {

        Review review = new Review();

        review.setId(reviewDto.getId());
        review.setIdUser(reviewDto.getIdUser());
        review.setIdFilm(reviewDto.getIdFilm());
        review.setComment(reviewDto.getComment());
        review.setUserName(reviewDto.getUserName());
        return review;
    }

    @Override
    public ReviewDto toDto(Review review) {

        ReviewDto reviewDto = new ReviewDto();

        reviewDto.setId(review.getId());
        reviewDto.setIdUser(review.getIdUser());
        reviewDto.setIdFilm(review.getIdFilm());
        reviewDto.setComment(review.getComment());
        reviewDto.setUserName(review.getUserName());

        return reviewDto;
    }

    @Override
    public List<ReviewDto> toDtoList(List<Review> list) {

        return
                list.stream()
                        .map(this::toDto)
                        .collect(Collectors.toList());
    }

}
