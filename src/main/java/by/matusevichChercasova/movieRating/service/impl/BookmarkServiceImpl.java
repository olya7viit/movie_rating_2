package by.matusevichChercasova.movieRating.service.impl;

import by.matusevichChercasova.movieRating.entity.Bookmark;
import by.matusevichChercasova.movieRating.entity.Film;
import by.matusevichChercasova.movieRating.repository.BookmarkRepository;
import by.matusevichChercasova.movieRating.repository.FilmRepository;
import by.matusevichChercasova.movieRating.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    private final FilmRepository filmRepository;

    @Autowired
    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository, FilmRepository filmRepository) {
        this.bookmarkRepository = bookmarkRepository;

        this.filmRepository = filmRepository;
    }

    @Override
    public boolean saveBookmark(Bookmark bookmark) {
        boolean flag = true;

        List<Bookmark> bookmarks =bookmarkRepository.findAllByIdUser(bookmark.getIdUser());

        for (Bookmark bookmark1 : bookmarks) {
            if (bookmark1.getIdFilm().equals(bookmark.getIdFilm()) &&
                    bookmark1.getIdUser().equals(bookmark.getIdUser())) {
                flag = false;
            }
        }

        if (!flag){
            bookmarkRepository.deleteBookmarkByIdUserAndIdFilm(bookmark.getIdUser(),bookmark.getIdFilm());
        }else {
            bookmarkRepository.save(bookmark);
        }
        return true;
    }

    @Override
    public List<Bookmark> allBookmarks(Long idUser) {

        return bookmarkRepository.findAllByIdUser(idUser);

    }

    @Override
    public List<Film> allBookmarksFilm(Long idUser) {

        List<Bookmark> bookmarks =bookmarkRepository.findAllByIdUser(idUser);

        List<Film> films= new ArrayList<Film>();

        for (Bookmark bookmark1 : bookmarks) {
            films.add(filmRepository.getOne(bookmark1.getIdFilm()));
            }

        return films;

    }
}
