package by.matusevichChercasova.movieRating.controller.impl;

import by.matusevichChercasova.movieRating.controller.BookmarkController;
import by.matusevichChercasova.movieRating.entity.Bookmark;
import by.matusevichChercasova.movieRating.service.BookmarkService;
import by.matusevichChercasova.movieRating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookmarkControllerImpl implements BookmarkController {

    @Autowired
    BookmarkService bookmarkService;
    @Autowired
    RatingService ratingService;

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
    @PostMapping("/deleteBookmark/{id}")
    public String deleteBookMark(@RequestParam("idFilm") Long idFilm,
                              @RequestParam("idUser") Long idUser,
                              Model model) {

        Bookmark bookmark = new Bookmark();
        bookmark.setIdFilm(idFilm);
        bookmark.setIdUser(idUser);
        bookmarkService.saveBookmark(bookmark);

        model.addAttribute("allFilms", bookmarkService.allBookmarksFilm(Long.valueOf(idUser)));
        model.addAttribute("ratingServise", ratingService);

        return "bookmarkPage";
    }


    @Override
    @PostMapping("/all-bookmarks")
    public String allBookmarks(Model model) {
        return null;
    }

    @Override
    @GetMapping("user/bookmarkPage/{id}")
    public String findAllFilms(@PathVariable String id, Model model) {

        model.addAttribute("allFilms", bookmarkService.allBookmarksFilm(Long.valueOf(id)));
        model.addAttribute("ratingServise", ratingService);

        return "bookmarkPage";
    }


}
