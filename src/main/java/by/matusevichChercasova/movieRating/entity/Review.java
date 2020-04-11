package by.matusevichChercasova.movieRating.entity;

import javax.persistence.*;


@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idUser;

    private Long idFilm;

    private String comment;

    private String userName;

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Review() {
    }

    public Review(Long idUser, Long idFilm, String comment, String userName) {
        this.idUser = idUser;
        this.idFilm = idFilm;
        this.comment = comment;
        this.userName = userName;
    }
}
