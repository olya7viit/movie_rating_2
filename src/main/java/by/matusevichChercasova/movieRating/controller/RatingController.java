package by.matusevichChercasova.movieRating.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface RatingController {
    String addRating(@RequestParam(defaultValue = "") String actorId,
                                @RequestParam(defaultValue = "") String action,
                                Model model);

    }
