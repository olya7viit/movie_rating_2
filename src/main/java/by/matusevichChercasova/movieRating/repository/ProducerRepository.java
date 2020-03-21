package by.matusevichChercasova.movieRating.repository;

import by.matusevichChercasova.movieRating.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
   Producer findBySurname(String producerSurname);
}