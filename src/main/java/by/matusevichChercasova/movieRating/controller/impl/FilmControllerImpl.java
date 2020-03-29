package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.FilmController;
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
    @GetMapping("/admin/filmsPage")
    public String findAllFilms(Model model) {

        model.addAttribute("filmForm", new FilmDto());

        model.addAttribute("allFilms", filmService.allFilms());

        initModelList(model);

        return "filmsPage";
    }

    @Override
    @PostMapping("/admin/filmsPage")
    public String workWithFilm(@RequestParam(defaultValue = "") Long filmId,
                               @RequestParam(defaultValue = "") String action,
                               Model model) {

        if (action.equals("delete")) {
            filmService.deleteFilm(filmId);
        }

        return "redirect:/admin/filmsPage";
    }

    private void initModelList(Model model) {
        List<ProducerDto> producerList = producerService.allProducers();//тут было Producer
        List<String> producerSurnames = new ArrayList<>();
        for (ProducerDto producer : producerList) {         //тут было Producer
            producerSurnames.add(producer.getSurname());
        }
        model.addAttribute("producerList", producerSurnames);
    }

    @Override
    @PostMapping("/admin/filmsPage/add-film")
    public String addFilm(@RequestParam("producer") String producerSurname,
                          @ModelAttribute("filmForm") @Validated FilmDto filmForm,
                          BindingResult bindingResult, Model model) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ProducerDto producerDto;

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        producerDto = producerService.loadProducerByProducerSurname(producerSurname);
        ProducerMapper producerMapper = new ProducerMapper(); System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Producer producer = producerMapper.toEntity(producerDto);
        filmForm.setProducer(producer); System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        if (bindingResult.hasErrors()) {

            System.out.println("error");
            return "filmsPage";

        }
        if (!filmService.saveFilm(filmForm)) {
            model.addAttribute("filmError", "Такой фильм уже существует");
            return "filmPage";
        }

        return "redirect:/admin/filmsPage";
    }

}
