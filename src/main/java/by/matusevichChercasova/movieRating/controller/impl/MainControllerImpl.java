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

    private static String checkedGenre = "Все";
    @Autowired
    FilmService filmService;
    @Autowired
    RatingService ratingService;


    @Override
    @GetMapping("/")
    public String findAllFilms(Model model) {
        model.addAttribute("allFilms", filmService.allFilms());
        model.addAttribute("ratingServise", ratingService);
        model.addAttribute("checkedGenre",checkedGenre);
        model.addAttribute("allNewFilm2020",filmService.allNewFilms());
        return "index";
    }

    @Override
    @PostMapping ("/search")
    public String search(@RequestParam("search") String search, Model model) {

        model.addAttribute("allFilms", filmService.searchFilm(search));
        model.addAttribute("allNewFilm2020",filmService.allNewFilms());
        model.addAttribute("ratingServise", ratingService);
        model.addAttribute("sizeSet",filmService.searchFilm(search).size());
        return "index";
    }

    @PostMapping ("/")
    public String loading( Model model) {


        model.addAttribute("allFilms", filmService.allFilms());
        model.addAttribute("allNewFilm2020",filmService.allNewFilms());
        model.addAttribute("ratingServise", ratingService);

        return "index";
    }

    @Override
    @PostMapping("/filter")
    public String filterByGenre(@RequestParam("genre") String genre, Model model) {

        checkedGenre = genre;
        model.addAttribute("allFilms", filmService.getByGenre(genre.toLowerCase()));
        model.addAttribute("allNewFilm2020",filmService.allNewFilms());
        model.addAttribute("ratingServise", ratingService);
        model.addAttribute("sizeSet",filmService.getByGenre(genre.toLowerCase()).size());
        model.addAttribute("checkedGenre",checkedGenre);
        return "index";
    }

    @Override
    @PostMapping("/sort")
    public String sortByRating(@RequestParam("sortType") String sortType, Model model) {

        checkedGenre = "Все";
        model.addAttribute("allFilms", filmService.getAllFilmSort(sortType));
        model.addAttribute("allNewFilm2020",filmService.allNewFilms());
        model.addAttribute("ratingServise", ratingService);
        model.addAttribute("sizeSet",filmService.getAllFilmSort(sortType).size());
        model.addAttribute("checkedGenre",checkedGenre);
        return "index";
    }
}
