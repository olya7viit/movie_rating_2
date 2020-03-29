package by.matusevichChercasova.movieRating.controller;

import by.matusevichChercasova.movieRating.dto.FilmDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

public interface FilmController {

    String findAllFilms(Model model);

    String workWithFilm(@RequestParam(defaultValue = "") Long filmId,
                        @RequestParam(defaultValue = "") String action,
                        Model model);

    String addFilm(@RequestParam("producer") String producerSurname,
                   @ModelAttribute("filmForm") @Validated FilmDto filmForm,
                   BindingResult bindingResult, Model model);
}
