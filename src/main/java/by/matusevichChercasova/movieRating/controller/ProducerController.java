package by.matusevichChercasova.movieRating.controller;

import by.matusevichChercasova.movieRating.dto.ProducerDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

public interface ProducerController {

    String allProducers(Model model);

    String newProducer(Model model);

    String workWithProducer(@RequestParam(defaultValue = "") Long producerId,
                        @RequestParam(defaultValue = "") String action,
                        Model model);

    String addProducer(@ModelAttribute("producerForm")
                       @Valid ProducerDto producerForm,
                       BindingResult bindingResult, Model model);

    String updateProducers(@RequestParam(required = true, defaultValue = "" ) Long producerId,
                           Model model);

    String updateFilm(@ModelAttribute("filmForm") @Validated ProducerDto producerForm,
                      BindingResult bindingResult, @RequestParam(required = true, defaultValue = "" ) Long producerId,
                      Model model);


    String allProducersForUser(Model model);

}
