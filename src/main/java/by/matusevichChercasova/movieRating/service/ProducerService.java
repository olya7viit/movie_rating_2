package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.dto.ProducerDto;
import by.matusevichChercasova.movieRating.entity.Producer;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface ProducerService {

    boolean saveProducer(ProducerDto producerDto);

    boolean deleteProducer(Long producerId);

    List<ProducerDto> allProducers();

    ProducerDto loadProducerByProducerSurname(String producerSurname) throws UsernameNotFoundException;
    Producer oneProducer(Long id);
    void updateProducer (ProducerDto producerDto);
}
