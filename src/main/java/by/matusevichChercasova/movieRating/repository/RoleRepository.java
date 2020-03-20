package by.matusevichChercasova.movieRating.repository;

import by.matusevichChercasova.movieRating.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}