package by.matusevichChercasova.movieRating.dto;

import javax.validation.constraints.NotNull;

public class ReviewDto extends AbstractDto {

    private Long idUser;

    private Long idFilm;

    @NotNull(message = "Введите  comment")
    private String comment;

    private String userName;

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

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public ReviewDto() {
    }
}
