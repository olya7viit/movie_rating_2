package by.matusevichChercasova.movieRating.dto.mapper;

import by.matusevichChercasova.movieRating.dto.ActorDto;
import by.matusevichChercasova.movieRating.entity.Actor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActorMapper implements Mapper<ActorDto, Actor>  {

    @Override
    public Actor toEntity(ActorDto actorDto) {

        Actor actor = new Actor();

        actor.setId(actorDto.getId());
        actor.setName(actorDto.getName());
        actor.setSurname(actorDto.getSurname());
        actor.setCountry(actorDto.getCountry());
        actor.setAge(actorDto.getAge());
        actor.setBiography(actorDto.getBiography());

        return actor;
    }

    @Override
    public ActorDto toDto(Actor actor) {

        ActorDto actorDto = new ActorDto();

        actorDto.setId(actor.getId());
        actorDto.setName(actor.getName());
        actorDto.setSurname(actor.getSurname());
        actorDto.setCountry(actor.getCountry());
        actorDto.setAge(actor.getAge());
        actorDto.setBiography(actor.getBiography());

        return actorDto;
    }

    @Override
    public List<ActorDto> toDtoList(List<Actor> list) {
        return
                list.stream()
                        .map(this::toDto)
                        .collect(Collectors.toList());
    }
}
