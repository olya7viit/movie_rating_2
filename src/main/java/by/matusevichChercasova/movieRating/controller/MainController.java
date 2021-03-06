package by.matusevichChercasova.movieRating.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface MainController {

    String findAllFilms(Model model);

    String search(@RequestParam("search") String search, Model model);

    String filterByGenre(@RequestParam("genre") String genre, Model model);

    String sortByRating(@RequestParam("sortType") String genre, Model model);
}
