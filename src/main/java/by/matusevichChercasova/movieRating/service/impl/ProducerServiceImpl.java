package by.matusevichChercasova.movieRating.service.impl;

import by.matusevichChercasova.movieRating.dto.ProducerDto;
import by.matusevichChercasova.movieRating.dto.mapper.ProducerMapper;
import by.matusevichChercasova.movieRating.entity.Producer;
import by.matusevichChercasova.movieRating.repository.ProducerRepository;
import by.matusevichChercasova.movieRating.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {

    private final ProducerMapper producerMapper;
    private final ProducerRepository producerRepository;

    @Autowired
    public ProducerServiceImpl(ProducerMapper producerMapper, ProducerRepository producerRepository) {
        this.producerMapper = producerMapper;
        this.producerRepository = producerRepository;
    }

    @Override
    public boolean saveProducer(ProducerDto producerDto) {

        Producer producer = producerMapper.toEntity(producerDto);

        producerRepository.findBySurname(producer.getName())
                .ifPresent(value -> {
                    throw new RuntimeException("Sorry producer is already present");
                });

        producerRepository.save(producer);

        return true;
    }

    @Override
    public boolean deleteProducer(Long producerId) {

        if (producerRepository.findById(producerId).isPresent()) {

            producerRepository.deleteById(producerId);

            return true;
        }
        return false;
    }

    @Override
    public List<ProducerDto> allProducers() {

        List<Producer> producers =producerRepository.findAll();

        return producerMapper.toDtoList(producers);

    }

    @Override
    public ProducerDto loadProducerByProducerSurname(String producerSurname) throws UsernameNotFoundException {

        Producer producer = producerRepository.findBySurname(producerSurname)
                .orElseThrow(() -> new RuntimeException("no producer with name=+" + producerSurname));

        ProducerDto producerDto = producerMapper.toDto(producer);

        return producerDto;
    }

}
