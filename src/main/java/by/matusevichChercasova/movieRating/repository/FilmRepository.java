package by.matusevichChercasova.movieRating.repository;

import by.matusevichChercasova.movieRating.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long> {
    Optional<Film> findByName(String filmName);
}
