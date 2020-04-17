package by.matusevichChercasova.movieRating.repository;

import by.matusevichChercasova.movieRating.entity.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {
    @Override
    Optional<Bookmark> findById(Long aLong);

    List<Bookmark> findAllByIdUser(Long idUser);

    @Transactional
    void deleteBookmarkByIdUserAndIdFilm(Long idUser, Long idFilm);
}
