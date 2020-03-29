package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.MainController;
import by.matusevichChercasova.movieRating.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControllerImpl implements MainController {

    @Autowired
    FilmService filmService;

    @Override
    @GetMapping("/")
    public String findAllFilms(Model model) {

        model.addAttribute("allFilms", filmService.allFilms());

        return "index";
    }

}
