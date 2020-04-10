package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.RatingController;
import by.matusevichChercasova.movieRating.dto.RatingDto;
import by.matusevichChercasova.movieRating.entity.User;
import by.matusevichChercasova.movieRating.service.RatingService;
import by.matusevichChercasova.movieRating.service.impl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RatingControllerImpl implements RatingController {

    @Autowired
    RatingService ratingService;

    @Override
    @PostMapping("/filmPage/{filmId}")
    public String addRating(@RequestParam(defaultValue = "") String filmId,
                                @RequestParam(defaultValue = "") String value,
                                Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        long idUser = user.getId();

        RatingDto ratingDto = new RatingDto();
        ratingDto.setIdUser(idUser);
        ratingDto.setIdFilm(Long.parseLong(filmId));
        ratingDto.setValue(Integer.parseInt(value));

        if(ratingService.isRatingExists(ratingDto) == -1){ //если такого рейтинга нет
            ratingService.saveRating(ratingDto);
        }else {
            ratingDto.setId(ratingService.isRatingExists(ratingDto));
            ratingService.updateRating(ratingDto);
        }



        return "redirect:/filmPage/{filmId}";
    }

}
