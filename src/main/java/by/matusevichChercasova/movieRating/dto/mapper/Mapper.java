package by.matusevichChercasova.movieRating.dto.mapper;

import by.matusevichChercasova.movieRating.dto.AbstractDto;

import java.util.List;

public interface Mapper<D extends AbstractDto,E> {

    E toEntity(D d);

    D toDto(E e);

    List<D> toDtoList(List<E> list);
}
