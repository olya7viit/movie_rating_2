package by.matusevichChercasova.movieRating.repository;

import by.matusevichChercasova.movieRating.dto.RatingDto;
import by.matusevichChercasova.movieRating.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    @Override
    Optional<Rating> findById(Long aLong);

    List<Rating> findAllByIdFilm(Long idFilm);
}
