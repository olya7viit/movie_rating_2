package by.matusevichChercasova.movieRating.dto.mapper;

import by.matusevichChercasova.movieRating.dto.FilmDto;
import by.matusevichChercasova.movieRating.entity.Film;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilmMapper implements Mapper<FilmDto, Film> {

    @Override
    public Film toEntity(FilmDto filmDto) {
        Film film= new Film();
        film.setId(filmDto.getId());
        film.setName(filmDto.getName());
        film.setProducer(filmDto.getProducer());
        film.setPhotoPath(filmDto.getPhotoPath());
        film.setAnnotation(filmDto.getAnnotation());
        film.setGenre(filmDto.getGenre());
        film.setReleaseYear(filmDto.getReleaseYear());
        film.setDuration(filmDto.getDuration());
        return film;
    }

    @Override
    public FilmDto toDto(Film film) {
        FilmDto filmDto = new FilmDto();
        filmDto.setId(film.getId());
        filmDto.setName(film.getName());
        filmDto.setProducer(film.getProducer());
        filmDto.setPhotoPath(film.getPhotoPath());
        filmDto.setAnnotation(film.getAnnotation());
        filmDto.setGenre(film.getGenre());
        filmDto.setReleaseYear(film.getReleaseYear());
        filmDto.setDuration(film.getDuration());

        return filmDto;
    }

    @Override
    public List<FilmDto> toDtoList(List<Film> list) {
        return
                list.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
