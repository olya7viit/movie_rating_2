package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.SortingController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SortingControllerImpl implements SortingController {
    @RequestMapping(value = "/mvcmethod", method = RequestMethod.POST)
    public String mvcmethod(Model model,
                          @RequestParam(value = "param1")String param){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!  " + param);
        return "redirect:/management";
    }

    @RequestMapping(value = "/mvcmethod", method = RequestMethod.GET)
    public String mvcmethod2(Model model,
                            @RequestParam(value = "param1")String param){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!  " + param);
        return "index";
    }
}
