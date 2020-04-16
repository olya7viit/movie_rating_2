package by.matusevichChercasova.movieRating.service.impl;

import by.matusevichChercasova.movieRating.entity.Bookmark;
import by.matusevichChercasova.movieRating.repository.BookmarkRepository;
import by.matusevichChercasova.movieRating.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Autowired
    public BookmarkServiceImpl(BookmarkRepository bookmarkRepository) {
        this.bookmarkRepository = bookmarkRepository;
    }

    @Override
    public boolean saveBookmark(Bookmark bookmark) {
        boolean flag = true;

        List<Bookmark> bookmarks =bookmarkRepository.findAllByIdUser(bookmark.getIdUser());

        for (int i=0;i<bookmarks.size();i++){
            if(bookmarks.get(i).getIdFilm() == bookmark.getIdFilm() &&
            bookmarks.get(i).getIdUser() == bookmark.getIdUser()){
                flag = false;
            }
        }

        if (flag){
            bookmarkRepository.delete(bookmark);
        }else {
            bookmarkRepository.save(bookmark);
        }
        return true;
    }

    @Override
    public void deleteBookmark(Long bookmarkId) {
        if (bookmarkRepository.findById(bookmarkId).isPresent()) {
            bookmarkRepository.deleteById(bookmarkId);
        }
    }

    @Override
    public List<Bookmark> allBookmarks(Long idUser) {
        List<Bookmark> bookmarks =bookmarkRepository.findAllByIdUser(idUser);
        return bookmarks;
    }
}
