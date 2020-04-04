package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.ActorController;
import by.matusevichChercasova.movieRating.dto.ActorDto;
import by.matusevichChercasova.movieRating.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Validated
public class ActorControllerImpl implements ActorController {

    @Autowired
    ActorService actorService;

    @Override
    @GetMapping("/management/addActor")

    public String addNewActor(Model model){

        model.addAttribute("actorForm", new ActorDto());

        return "addActor";
    }
    @Override
    @PostMapping("/management/addActor")
    public String addActor(@ModelAttribute("actorForm")
                              @Validated ActorDto actorForm,
                              BindingResult bindingResult, Model model) {



        if (bindingResult.hasErrors()) {

            System.out.println("error"+bindingResult.getAllErrors());
            return "addActor";

        }
        if (!actorService.saveActor(actorForm)){
           // model.addAttribute("newProducerError", "Продюсер с таким именем уже существует");
            return "management";
        }

        return "redirect:/management";
    }





}
