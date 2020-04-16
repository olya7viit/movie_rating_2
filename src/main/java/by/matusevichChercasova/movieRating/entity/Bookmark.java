package by.matusevichChercasova.movieRating.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookmark")
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBookmark;

    private Long idUser;

    private Long idFilm;

    public Bookmark() {
    }

    public Bookmark(Long idUser, Long idFilm) {
        this.idUser = idUser;
        this.idFilm = idFilm;
    }

    public Long getIdBookmark() {
        return idBookmark;
    }

    public void setIdBookmark(Long idBookmark) {
        this.idBookmark = idBookmark;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Long idFilm) {
        this.idFilm = idFilm;
    }
}
