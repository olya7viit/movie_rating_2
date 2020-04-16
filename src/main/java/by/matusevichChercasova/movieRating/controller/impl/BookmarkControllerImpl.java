package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.BookmarkController;
import by.matusevichChercasova.movieRating.entity.Bookmark;
import by.matusevichChercasova.movieRating.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookmarkControllerImpl implements BookmarkController {

    @Autowired
    BookmarkService bookmarkService;

    @Override
    @PostMapping("/add-bookmark")
    public String addBookmark(@RequestParam("idFilm") Long idFilm,
                              @RequestParam("idUser") Long idUser,
                              Model model) {

        Bookmark bookmark = new Bookmark();
        bookmark.setIdFilm(idFilm);
        bookmark.setIdUser(idUser);
        bookmarkService.saveBookmark(bookmark);

        return "redirect:/";
    }

    @Override
    @PostMapping("/all-bookmarks")
    public String allBookmarks(Model model) {
        return null;
    }

}
