package by.matusevichChercasova.movieRating.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

public interface AdminController {

    String manage(Model model);

    //String userList(Model model);


    String workWithUser(@RequestParam(defaultValue = "") Long userId,
                        @RequestParam(defaultValue = "") String action,
                        Model model);
    String viewInf();
}
