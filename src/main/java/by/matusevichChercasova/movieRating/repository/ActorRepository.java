package by.matusevichChercasova.movieRating.repository;

import by.matusevichChercasova.movieRating.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor,Long> {
    @Override
    Optional<Actor> findById(Long aLong);


}
