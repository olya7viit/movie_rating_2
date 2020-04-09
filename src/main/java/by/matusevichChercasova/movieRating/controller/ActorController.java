package by.matusevichChercasova.movieRating.controller;


import by.matusevichChercasova.movieRating.dto.ActorDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

public interface ActorController {

        String allActorsForUser(Model model);

        String workWithActor(@RequestParam(defaultValue = "") Long actorId,
                            @RequestParam(defaultValue = "") String action,
                            Model model);

        String updateActors(@RequestParam(required = true, defaultValue = "" ) Long actorId,
                           Model model);

        String addActor(@ModelAttribute("actorForm") @Validated ActorDto actorForm,
                       BindingResult bindingResult, Model model);

        String addNewActor(Model model);

        String updateActor(@ModelAttribute("actorForm") @Validated ActorDto actorForm,
                          BindingResult bindingResult, @RequestParam(required = true, defaultValue = "" ) Long actorId,
                          Model model);
    }


