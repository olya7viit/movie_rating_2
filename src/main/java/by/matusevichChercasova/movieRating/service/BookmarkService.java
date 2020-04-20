package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.entity.Bookmark;
import by.matusevichChercasova.movieRating.entity.Film;

import java.util.List;

public interface BookmarkService {
    boolean saveBookmark(Bookmark bookmark);

    List<Film> allBookmarksFilm(Long idUser);

    List<Bookmark> allBookmarks(Long idFilm);
}
