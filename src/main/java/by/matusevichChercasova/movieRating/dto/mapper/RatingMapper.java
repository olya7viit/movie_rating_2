package by.matusevichChercasova.movieRating.dto.mapper;

import by.matusevichChercasova.movieRating.dto.RatingDto;
import by.matusevichChercasova.movieRating.entity.Rating;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RatingMapper implements Mapper<RatingDto, Rating>{

    @Override
    public Rating toEntity(RatingDto ratingDto) {
        Rating rating = new Rating();

        rating.setValue(ratingDto.getValue());
        rating.setIdFilm(ratingDto.getIdFilm());
        rating.setIdUser(ratingDto.getIdUser());

        return rating;
    }

    @Override
    public RatingDto toDto(Rating rating) {
        RatingDto ratingDto = new RatingDto();

        ratingDto.setValue(rating.getValue());
        ratingDto.setIdFilm(rating.getIdFilm());
        ratingDto.setIdUser(rating.getIdUser());

        return ratingDto;
    }

    @Override
    public List<RatingDto> toDtoList(List<Rating> list) {
        return
                list.stream()
                        .map(this::toDto)
                        .collect(Collectors.toList());
    }
}
