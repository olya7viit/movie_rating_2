package by.matusevichChercasova.movieRating.repository;

import by.matusevichChercasova.movieRating.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

   @Override
   Optional<Producer> findById(Long aLong);

   Optional<Producer> findBySurname(String producerSurname);

}