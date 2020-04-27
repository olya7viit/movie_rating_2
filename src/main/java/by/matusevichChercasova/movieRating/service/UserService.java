package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.entity.User;

import java.util.List;

public interface UserService {

    int countUsers();

    List<User> allUsers();

    boolean saveUser(User user);

    boolean deleteUser(Long userId);

    User findUserById(Long userId);
}
