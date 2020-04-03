package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.dto.FilmAddDto;
import by.matusevichChercasova.movieRating.dto.FilmDto;
import by.matusevichChercasova.movieRating.entity.Film;
import java.util.List;

public interface FilmService {

    List<Film> allFilms();

    Film getFilm(Long id);

    void updateFilm (FilmAddDto filmDto);

    boolean saveFilm(FilmAddDto filmDto);

    boolean deleteFilm(Long filmId);
}
