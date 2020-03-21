package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.entity.Film;
import by.matusevichChercasova.movieRating.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class FilmService {
    @Autowired
    FilmRepository filmRepository;

    public boolean saveFilm(Film film) {
        Film filmFromDB = filmRepository.findByName(film.getName());

        if (filmFromDB != null) {
            return false;
        }

       /* film.
        film.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);*/
        return true;
    }

}
