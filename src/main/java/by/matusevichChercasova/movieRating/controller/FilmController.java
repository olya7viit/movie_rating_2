package by.matusevichChercasova.movieRating.controller;

import by.matusevichChercasova.movieRating.entity.Film;
import by.matusevichChercasova.movieRating.entity.Producer;
import by.matusevichChercasova.movieRating.service.FilmService;
import by.matusevichChercasova.movieRating.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmController {

    @Autowired
    FilmService filmService;
    @Autowired
    ProducerService producerService;

    @GetMapping("/admin/filmsPage")
    public String findAllFilms(Model model) {

       model.addAttribute("filmForm", new Film());

       model.addAttribute("allFilms", filmService.allFilms());

       initModelList(model);

        return "filmsPage";
    }

    @PostMapping("/admin/filmsPage")
    public String  workWithFilm(@RequestParam(required = true, defaultValue = "" ) Long filmId,
                              @RequestParam(required = true, defaultValue = "" ) String action,
                              Model model) {
        if (action.equals("delete")){
            filmService.deleteFilm(filmId);
        }
        return "redirect:/admin/filmsPage";
    }

    private void initModelList(Model model) {
        List<Producer> producerList = producerService.allProducers();
        List<String> producerSurnames = new ArrayList<>();
        for (Producer producer : producerList) {
            producerSurnames.add(producer.getSurname());
        }
        model.addAttribute("producerList", producerSurnames);
    }

    @PostMapping("/admin/filmsPage/add-film")
    public String addFilm(@RequestParam("producer") String producerSurname,
            @ModelAttribute("filmForm") @Valid Film filmForm, BindingResult bindingResult, Model model) {

        Producer producer;

        producer = producerService.loadProducerByProducerSurname(producerSurname);

        filmForm.setProducer(producer);

        if (bindingResult.hasErrors()) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            return "filmPage";
        }
        if (!filmService.saveFilm(filmForm)){
            model.addAttribute("filmError", "Такой фильм уже существует");
            return "filmPage";
        }

        return "redirect:/admin/filmsPage";
    }

}
