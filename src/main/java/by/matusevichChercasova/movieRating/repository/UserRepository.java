package by.matusevichChercasova.movieRating.repository;

import by.matusevichChercasova.movieRating.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}