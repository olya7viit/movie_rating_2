package by.matusevichChercasova.movieRating.dto.mapper;

import by.matusevichChercasova.movieRating.dto.ProducerDto;
import by.matusevichChercasova.movieRating.entity.Producer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProducerMapper implements Mapper<ProducerDto, Producer> {

    @Override
    public Producer toEntity(ProducerDto producerDto) {

        Producer producer = new Producer();

        producer.setId(producerDto.getId());
        producer.setName(producerDto.getName());
        producer.setSurname(producerDto.getSurname());
        producer.setBiography(producerDto.getBiography());
        producer.setCountry(producerDto.getCountry());
        producer.setPhotoPath(producerDto.getPhotoPath());
        producer.setFilms(producerDto.getFilms());

        return producer;
    }

    @Override
    public ProducerDto toDto(Producer producer) {

        ProducerDto producerDto = new ProducerDto();

        producerDto.setId(producer.getId());
        producerDto.setName(producer.getName());
        producerDto.setSurname(producer.getSurname());
        producerDto.setCountry(producer.getCountry());
        producerDto.setBiography(producer.getBiography());
        producerDto.setPhotoPath(producer.getPhotoPath());
        producerDto.setFilms(producer.getFilms());

        return producerDto;
    }

    @Override
    public List<ProducerDto> toDtoList(List<Producer> list) {


        return
                list.stream()
                        .map(this::toDto)
                        .collect(Collectors.toList());
    }

}
