package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.FilmController;
import by.matusevichChercasova.movieRating.dto.FilmAddDto;
import by.matusevichChercasova.movieRating.dto.FilmDto;
import by.matusevichChercasova.movieRating.dto.ProducerDto;
import by.matusevichChercasova.movieRating.dto.mapper.ProducerMapper;
import by.matusevichChercasova.movieRating.entity.Producer;
import by.matusevichChercasova.movieRating.service.FilmService;
import by.matusevichChercasova.movieRating.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@Validated
public class FilmControllerImpl implements FilmController {

    @Autowired
    FilmService filmService;
    @Autowired
    ProducerService producerService;

    @Override
    @GetMapping("/management/addFilm")
    public String addNewFilm(Model model) {

        model.addAttribute("filmForm", new FilmAddDto());
        model.addAttribute("allProducers",producerService.allProducers());


        return "addFilm";
    }

    @Override
    @GetMapping("/management/updateFilm")
    public String updateFilms(@RequestParam(required = true, defaultValue = "" ) Long filmId,Model model) {

        model.addAttribute("filmForm", new FilmAddDto());
        model.addAttribute("oneFilm",filmService.getFilm(filmId));
        model.addAttribute("allProducers",producerService.allProducers());

        return "updateFilm";
    }

    @Override
    @PostMapping("/management/updateFilm")
    public String updateFilm(@RequestParam("producerId") Long producerId,
                             @ModelAttribute("filmForm") @Validated FilmAddDto filmForm,
                             BindingResult bindingResult, @RequestParam(required = true, defaultValue = "" ) Long filmId,
                             Model model) {

        filmForm.setId(filmId);

        if (bindingResult.hasErrors()) {
            model.addAttribute("allProducers",producerService.allProducers());
            return "updateFilm";
        }

        filmService.updateFilm(filmForm);

        return "redirect:/management";
    }

    @Override
    @PostMapping("/management/filmsPage")
    public String workWithFilm(@RequestParam(defaultValue = "") Long filmId,
                               @RequestParam(defaultValue = "") String action,
                               Model model) {

        if (action.equals("delete")) {
            filmService.deleteFilm(filmId);
        }

        return "redirect:/management";
    }

    @Override
    @PostMapping("/management/addOneFilm")
    public String addFilm(@RequestParam("producerId") String producerSurname,
                          @ModelAttribute("filmForm") @Validated FilmAddDto filmForm,
                          BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            System.out.println("error"+bindingResult.getAllErrors());
            model.addAttribute("allProducers",producerService.allProducers());
            return "addOneFilm";
        }
        if (!filmService.saveFilm(filmForm)) {
            model.addAttribute("filmError", "Такой фильм уже существует");
            return "addOneFilm";
        }

        return "redirect:/management";
    }

    @Override
    @GetMapping("/filmPage/{id}")
    public String filmPage(@PathVariable String id, Model model){

        model.addAttribute("oneFilm", filmService.getFilm(Long.valueOf(id)));

        return "filmPage";
    }


}
