package by.matusevichChercasova.movieRating.service;

import by.matusevichChercasova.movieRating.dto.ActorDto;
import by.matusevichChercasova.movieRating.entity.Actor;

import java.util.List;

public interface ActorService {
    boolean saveActor(ActorDto actorDto);

    boolean deleteActor(Long actorId);

    List<ActorDto> allActors();

    Actor oneActor(Long id);
   // void updateActor (ActorDto actorDto);
}
