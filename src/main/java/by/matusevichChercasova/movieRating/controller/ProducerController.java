package by.matusevichChercasova.movieRating.controller;

import by.matusevichChercasova.movieRating.dto.ProducerDto;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

public interface ProducerController {

    String newProducer(Model model);

    String addProducer(@ModelAttribute("producerForm")
                       @Valid ProducerDto producerForm,
                       BindingResult bindingResult, Model model);

}
