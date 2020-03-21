package by.matusevichChercasova.movieRating.repository;

import by.matusevichChercasova.movieRating.entity.Film;
import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film, Long> {
    Film findByName(String filmName);
}
