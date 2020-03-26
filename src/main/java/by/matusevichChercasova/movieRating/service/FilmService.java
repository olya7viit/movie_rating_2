package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.entity.Film;
import by.matusevichChercasova.movieRating.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmService {
    @Autowired
    FilmRepository filmRepository;

    public List<Film> allFilms() {
        return filmRepository.findAll();
    }

    public boolean saveFilm(Film film) {
        Film filmFromDB = filmRepository.findByName(film.getName());

        if (filmFromDB != null) {
            return false;
        }
        film.setPhotoPath("нету");/////////////////////////////////////////////////

        filmRepository.save(film);

        return true;
    }

    public boolean deleteFilm(Long filmId) {
        if (filmRepository.findById(filmId).isPresent()) {
            filmRepository.deleteById(filmId);
            return true;
        }
        return false;
    }

}
