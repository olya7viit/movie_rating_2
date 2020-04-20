package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.AdminController;
import by.matusevichChercasova.movieRating.dto.ProducerDto;
import by.matusevichChercasova.movieRating.service.ActorService;
import by.matusevichChercasova.movieRating.service.FilmService;
import by.matusevichChercasova.movieRating.service.ProducerService;
import by.matusevichChercasova.movieRating.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminControllerImpl implements AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private ProducerService producerService;
    @Autowired
    private ActorService actorService;

    @Override
    @GetMapping("/management")
    public String manage(Model model) {

        model.addAttribute("allFilms", filmService.allFilms());
        model.addAttribute("allActors", actorService.allActors());
        model.addAttribute("allProducers", producerService.allProducers());
        model.addAttribute("allUser",userService.allUsers());
        initModelList(model);

        return "management";
    }

    @Override
    @PostMapping("/management/usersPage")
    public String workWithUser(@RequestParam(defaultValue = "") Long userId,
                                @RequestParam(defaultValue = "") String action,
                                Model model) {

        if (action.equals("delete")) {
           userService.deleteUser(userId);
        }
        return "redirect:/management";
    }


    @Override
    @GetMapping("/allusers")
    public String viewInf(){
        return "allusers";
    }

    private void initModelList(Model model) {
        List<ProducerDto> producerList = producerService.allProducers();
        List<String> producerSurnames = new ArrayList<>();
        for (ProducerDto producer : producerList) {
            producerSurnames.add(producer.getSurname());
        }
        model.addAttribute("producerList", producerSurnames);
    }
}