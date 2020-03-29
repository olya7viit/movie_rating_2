package by.matusevichChercasova.movieRating.dto;

import java.io.Serializable;

public class AbstractDto implements Serializable {

    private Long id;

    public AbstractDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
