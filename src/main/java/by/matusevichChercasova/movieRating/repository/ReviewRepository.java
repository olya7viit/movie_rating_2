package by.matusevichChercasova.movieRating.repository;

import by.matusevichChercasova.movieRating.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Override
    Optional<Review> findById(Long aLong);


    List<Review> findAllByIdFilm(Long idFilm);
}
