package by.matusevichChercasova.movieRating.controller;

import by.matusevichChercasova.movieRating.entity.User;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.validation.Valid;

public interface RegistrationController {

    String registration(Model model);

    String addUser(@ModelAttribute("userForm")
                   @Valid User userForm,
                   BindingResult bindingResult,
                   Model model);

}
