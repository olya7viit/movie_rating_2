package by.matusevichChercasova.movieRating.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface BookmarkController {

    @PostMapping("/add-bookmark")
    String addBookmark(@RequestParam("idFilm") Long idFilm,
                       @RequestParam("idUser") Long idUser,
                       Model model);

    @GetMapping("/all-bookmarks")
    String allBookmarks(Model model);
}
