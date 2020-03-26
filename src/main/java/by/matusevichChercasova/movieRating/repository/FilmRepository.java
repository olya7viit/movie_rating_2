package by.matusevichChercasova.movieRating.repository;

import by.matusevichChercasova.movieRating.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
    Film findByName(String filmName);
}
