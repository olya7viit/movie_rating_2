package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.MainController;
import by.matusevichChercasova.movieRating.service.FilmService;
import by.matusevichChercasova.movieRating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControllerImpl implements MainController {

    @Autowired
    FilmService filmService;
    @Autowired
    RatingService ratingService;

    @Override
    @GetMapping("/")
    public String findAllFilms(Model model) {

        model.addAttribute("allFilms", filmService.allFilms());
        model.addAttribute("ratingServise", ratingService);

        return "index";
    }

}
