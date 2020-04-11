package by.matusevichChercasova.movieRating.controller;

import by.matusevichChercasova.movieRating.dto.ReviewDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

public interface ReviewController {
    String filmAddCooment(@ModelAttribute("reviewForm") @Validated ReviewDto reviewForm,
                          BindingResult bindingResult, @RequestParam("idFilm") Long id,
                          @RequestParam("idUser") Long idUser, Model model);
}
