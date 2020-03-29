package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.ProducerController;
import by.matusevichChercasova.movieRating.dto.ProducerDto;
import by.matusevichChercasova.movieRating.entity.Producer;
import by.matusevichChercasova.movieRating.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProducerControllerImpl implements ProducerController {

    @Autowired
    private ProducerService producerService;

    @Override
    @GetMapping("/admin/producerPage")
    public String newProducer(Model model){

        model.addAttribute("producerForm", new Producer());

        model.addAttribute("allProducers", producerService.allProducers());

        return "producerPage";
    }

    @Override
    @PostMapping("/admin/producerPage")
    public String addProducer(@ModelAttribute("producerForm")
                                  @Valid ProducerDto producerForm,
                              BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "producerPage";
        }
        if (!producerService.saveProducer(producerForm)){
            model.addAttribute("newProducerError", "Продюсер с таким именем уже существует");
            return "producerPage";
        }

        return "redirect:/admin";
    }

}
