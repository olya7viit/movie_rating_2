package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.ReviewController;
import by.matusevichChercasova.movieRating.dto.ReviewDto;
import by.matusevichChercasova.movieRating.service.ReviewService;
import by.matusevichChercasova.movieRating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Validated
public class ReviewControllerImpl implements ReviewController {

    @Autowired
    ReviewService reviewService;
    @Autowired
    UserService userService;

    @Override
    @PostMapping("/filmPage/addComment/{id}")
    public String filmAddCooment(@ModelAttribute("reviewForm") @Validated ReviewDto reviewForm,
                                 BindingResult bindingResult,
                                 @RequestParam("idFilm") Long id,
                                 @RequestParam("idUser") Long idUser, Model model){

        if (bindingResult.hasErrors()) {
            System.out.println("error"+bindingResult.getAllErrors());
            return "filmPage/{id}";
        }

        reviewForm.setUserName(userService.findUserById(idUser).getUsername());
        reviewService.saveReview(reviewForm);

        return "redirect:/filmPage/{id}";
    }

    @PostMapping("/filmPage/deleteReview/{id}")
    public String dellComment(@RequestParam(defaultValue = "") Long reviewId,
                              @RequestParam(defaultValue = "") String action,
                              Model model){

        if (action.equals("delete")) {
            reviewService.deleteReview(reviewId);
        }
        return "redirect:/filmPage/{id}";
    }

}
