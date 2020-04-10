package by.matusevichChercasova.movieRating.dto;

public class RatingDto extends AbstractDto {

    private int value;

    private long idFilm;

    private long idUser;

    public RatingDto(){}


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(long idFilm) {
        this.idFilm = idFilm;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "RatingDto{" +
                "value=" + value +
                ", idFilm=" + idFilm +
                ", idUser=" + idUser +
                '}';
    }
}
