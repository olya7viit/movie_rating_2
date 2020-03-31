package by.matusevichChercasova.movieRating.service.impl;

import by.matusevichChercasova.movieRating.dto.FilmDto;
import by.matusevichChercasova.movieRating.dto.mapper.FilmMapper;
import by.matusevichChercasova.movieRating.entity.Film;
import by.matusevichChercasova.movieRating.repository.FilmRepository;
import by.matusevichChercasova.movieRating.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmMapper filmMapper;
    private final FilmRepository filmRepository;

    @Autowired
    public FilmServiceImpl(FilmMapper filmMapper,
                           FilmRepository filmRepository) {
        this.filmMapper = filmMapper;
        this.filmRepository = filmRepository;
    }

    @Override
    public List<Film> allFilms() {
        return filmRepository.findAll();
    }

    @Override
    public boolean saveFilm(FilmDto filmDto) {
        Film film = filmMapper.toEntity(filmDto);

        filmRepository.findByName(film.getName())
                .ifPresent(value -> {
                    throw new RuntimeException("Sorry film is already present");
                });
        filmRepository.save(film);

        return true;
    }

    @Override
    public boolean deleteFilm(Long filmId) {
        if (filmRepository.findById(filmId).isPresent()) {
            filmRepository.deleteById(filmId);
            return true;
        }
        return false;
    }

    @Override
    public Film getFilm(Long id) {

        return filmRepository.getOne(id);

    }
    @Override
    public void updateFilm(FilmDto filmDto) {

        Film film = filmMapper.toEntity(filmDto);

        filmRepository.save(film);

    }

}
