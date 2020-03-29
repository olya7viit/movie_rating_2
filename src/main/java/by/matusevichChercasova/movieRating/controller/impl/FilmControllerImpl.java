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

       // model.addAttribute("filmForm", new FilmDto());

        model.addAttribute("allFilms", filmService.allFilms());

        initModelList(model);

        return "filmsPage";
    }
    @Override
    @GetMapping("/admin/addFilm")
    public String addOneFilm(Model model) {

        model.addAttribute("filmForm", new FilmDto());
        initModelList(model);

        return "addFilm";
    }
    @Override
    @GetMapping("/admin/updateFilm")
    public String updateFilms(@RequestParam(required = true, defaultValue = "" ) Long filmId,Model model) {

        model.addAttribute("filmForm", new FilmDto());

        initModelList(model);

        model.addAttribute("oneFilm",filmService.oneFilm(filmId));

        return "updateFilm";
    }
    @Override
    @PostMapping("/admin/updateFilm")
    public String updateFilm(@RequestParam("producer") String producerSurname,
                             @ModelAttribute("filmForm") @Validated FilmDto filmForm,
                             BindingResult bindingResult, @RequestParam(required = true, defaultValue = "" ) Long filmId,
                             Model model) {

        ProducerDto producerDto;
        producerDto = producerService.loadProducerByProducerSurname(producerSurname);
        ProducerMapper producerMapper = new ProducerMapper();
        Producer producer = producerMapper.toEntity(producerDto);
        filmForm.setProducer(producer);
        filmForm.setId(filmId);
        filmForm.setPhotoPath("photo");
//        if (bindingResult.hasErrors()) {
//
//            System.out.println("error");
//            return "filmsPage";
//
//        }

        filmService.updateFilm(filmForm);

        return "redirect:/admin/filmsPage";

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
    @PostMapping("/admin/addOneFilm/add-film")
    public String addFilm(@RequestParam("producer") String producerSurname,
                          @ModelAttribute("filmForm") @Validated FilmDto filmForm,
                          BindingResult bindingResult, Model model) {

        ProducerDto producerDto;

        producerDto = producerService.loadProducerByProducerSurname(producerSurname);

        ProducerMapper producerMapper = new ProducerMapper();

        Producer producer = producerMapper.toEntity(producerDto);

        filmForm.setProducer(producer);


//        if (bindingResult.hasErrors()) {
//
//            System.out.println("error"+bindingResult.getAllErrors());
//            return "filmsPage";
//
//        }
        if (!filmService.saveFilm(filmForm)) {
            model.addAttribute("filmError", "Такой фильм уже существует");
            return "filmsPage";
        }

        return "redirect:/admin/filmsPage";
    }

}
