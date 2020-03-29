package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.dto.FilmDto;
import by.matusevichChercasova.movieRating.entity.Film;
import java.util.List;

public interface FilmService {

    List<Film> allFilms();

    boolean saveFilm(FilmDto filmDto);

    boolean deleteFilm(Long filmId);
}
