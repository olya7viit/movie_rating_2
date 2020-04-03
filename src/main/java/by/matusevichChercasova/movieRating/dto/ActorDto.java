package by.matusevichChercasova.movieRating.dto;

import javax.validation.constraints.NotNull;

public class ActorDto extends AbstractDto {

    public ActorDto(){}

    @NotNull(message = "Введите имя")
    private String name;

    @NotNull(message = "Введите фамилию")
    private String surname;

    @NotNull(message = "Введите страну")
    private String country;

    @NotNull(message = "Введите возраст")
    private int age;

    @NotNull(message = "Введите биографию")
    private String biography;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
