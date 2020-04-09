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
import org.springframework.web.bind.annotation.RequestParam;

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
    @GetMapping("/management/updateActor")
    public String updateActors(@RequestParam(required = true, defaultValue = "" ) Long actorId, Model model) {

        model.addAttribute("actorForm", new ActorDto());

        model.addAttribute("oneActor",actorService.oneActor(actorId));

        return "updateActor";
    }
    @Override
    @PostMapping("/management/updateActor")
    public String updateActor(@ModelAttribute("actorForm") @Validated ActorDto actorForm,
                                 BindingResult bindingResult, @RequestParam(required = true, defaultValue = "" ) Long actorId,
                                 Model model) {

        if (bindingResult.hasErrors()) {

            System.out.println("error"+bindingResult.getAllErrors());
            return "updateActor";

        }
        actorForm.setId(actorId);
      actorService.updateActor(actorForm);

        return "redirect:/management";

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

    @Override
    @PostMapping("/management/actorsPage")
    public String workWithActor(@RequestParam(defaultValue = "") Long actorId,
                                   @RequestParam(defaultValue = "") String action,
                                   Model model) {

        if (action.equals("delete")) {
            actorService.deleteActor(actorId);
        }

        return "redirect:/management";
    }

    @Override
    @GetMapping("/user/allActors")
    public String allActorsForUser(Model model){

        model.addAttribute("allActors", actorService.allActors());

        return "allActors";
    }

}
