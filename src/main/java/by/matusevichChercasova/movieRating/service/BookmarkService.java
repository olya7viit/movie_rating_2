package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.entity.Bookmark;

import java.util.List;

public interface BookmarkService {
    boolean saveBookmark(Bookmark bookmark);

    void deleteBookmark(Long bookmarkId);

    List<Bookmark> allBookmarks(Long idFilm);
}
