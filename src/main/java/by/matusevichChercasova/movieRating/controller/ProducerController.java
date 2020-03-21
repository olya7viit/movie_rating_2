package by.matusevichChercasova.movieRating.controller;

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
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/admin/newProducer")
    public String newProducer(Model model){
        model.addAttribute("producerForm", new Producer());
        return "newProducer";
    }

    @PostMapping("/admin/newProducer")
    public String addProducer(@ModelAttribute("producerForm") @Valid Producer producerForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "newProducer";
        }
        if (!producerService.saveProducer(producerForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration";
        }

        return "redirect:/admin";
    }

}
