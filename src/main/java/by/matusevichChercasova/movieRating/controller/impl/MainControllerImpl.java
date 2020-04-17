package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.MainController;
import by.matusevichChercasova.movieRating.service.FilmService;
import by.matusevichChercasova.movieRating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    @Override
    @PostMapping ("/search")
    public String search(@RequestParam("search") String search, Model model) {

        model.addAttribute("allFilms", filmService.searchFilm(search));
        model.addAttribute("ratingServise", ratingService);
        model.addAttribute("sizeSet",filmService.searchFilm(search).size());

        return "index";
    }

}
