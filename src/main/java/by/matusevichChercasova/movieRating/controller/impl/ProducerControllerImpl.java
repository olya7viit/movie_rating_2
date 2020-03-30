package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.ProducerController;
import by.matusevichChercasova.movieRating.dto.ProducerDto;
import by.matusevichChercasova.movieRating.entity.Producer;
import by.matusevichChercasova.movieRating.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ProducerControllerImpl implements ProducerController {

    @Autowired
    private ProducerService producerService;

    @Override
    @GetMapping("/admin/producerPage")
    public String newProducer(Model model){

       // model.addAttribute("producerForm", new Producer());

        model.addAttribute("allProducers", producerService.allProducers());

        return "producerPage";
    }
    @Override
    @GetMapping("/admin/addProducer")
    public String addOneProducer(Model model){

        model.addAttribute("producerForm", new ProducerDto());

        return "addProducer";
    }
    @Override
    @GetMapping("/admin/updateProducer")
    public String updateProducers(@RequestParam(required = true, defaultValue = "" ) Long producerId,Model model) {

        model.addAttribute("producerForm", new ProducerDto());

        model.addAttribute("oneProducer",producerService.oneProducer(producerId));

        return "updateProducer";
    }
    @Override
    @PostMapping("/admin/updateProducer")
    public String updateFilm(@ModelAttribute("filmForm") @Validated ProducerDto producerForm,
                             BindingResult bindingResult, @RequestParam(required = true, defaultValue = "" ) Long producerId,
                             Model model) {

        if (bindingResult.hasErrors()) {

            System.out.println("error"+bindingResult.getAllErrors());
            return "producerPage";

        }
        producerForm.setId(producerId);
       producerService.updateFilm(producerForm);

        return "redirect:/admin/producerPage";

    }
    @Override
    @PostMapping("/admin/producerPage")
    public String workWithProducer(@RequestParam(defaultValue = "") Long producerId,
                               @RequestParam(defaultValue = "") String action,
                               Model model) {

        if (action.equals("delete")) {
            producerService.deleteProducer(producerId);
        }

        return "redirect:/admin/producerPage";
    }
    @Override
    @PostMapping("/admin/addOneProducer/add-Producer")
    public String addProducer(@ModelAttribute("producerForm")
                                  @Valid ProducerDto producerForm,
                              BindingResult bindingResult, Model model) {



        if (bindingResult.hasErrors()) {

           System.out.println("error"+bindingResult.getAllErrors());
            return "producerPage";

       }
        if (!producerService.saveProducer(producerForm)){
            model.addAttribute("newProducerError", "Продюсер с таким именем уже существует");
            return "producerPage";
        }

        return "redirect:/admin";
    }

}
