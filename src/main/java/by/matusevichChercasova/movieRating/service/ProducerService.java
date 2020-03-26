package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.entity.Producer;
import by.matusevichChercasova.movieRating.repository.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerService {
    @Autowired
    ProducerRepository producerRepository;

    public boolean saveProducer(Producer producer) {
        Producer producerFromDB = producerRepository.findBySurname(producer.getSurname());

        if (producerFromDB != null) { //если уже существует с такой фамилией
            return false;
        }

        producer.setPhotoPath("ничего");

        producerRepository.save(producer);
        return true;
    }

    public boolean deleteProducer(Long producerId) {
        if (producerRepository.findById(producerId).isPresent()) {
            producerRepository.deleteById(producerId);
            return true;
        }
        return false;
    }

    public List<Producer> allProducers() {
        return producerRepository.findAll();
    }

    public Producer loadProducerByProducerSurname(String producerSurname) throws UsernameNotFoundException {

        Producer producer = producerRepository.findBySurname(producerSurname);

        if (producer == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return producer;
    }
}
