package by.matusevichChercasova.movieRating.service.impl;

import by.matusevichChercasova.movieRating.dto.ActorDto;
import by.matusevichChercasova.movieRating.dto.mapper.ActorMapper;
import by.matusevichChercasova.movieRating.entity.Actor;
import by.matusevichChercasova.movieRating.repository.ActorRepository;
import by.matusevichChercasova.movieRating.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {
    private ActorRepository actorRepository;
    private ActorMapper actorMapper;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository, ActorMapper actorMapper) {

        this.actorRepository = actorRepository;

        this.actorMapper = actorMapper;
    }
    @Override
    public boolean saveActor(ActorDto actorDto){

        Actor actor=actorMapper.toEntity(actorDto);

        actorRepository.save(actor);

        return true;

}
    @Override
    public boolean deleteActor(Long actorId){

        if(actorRepository.findById(actorId).isPresent()){

        actorRepository.deleteById(actorId);

        return true;
        }

        return false;
    }
@Override
public List<ActorDto> allActors(){

        List<Actor> actors=actorRepository.findAll();
        return actorMapper.toDtoList(actors);

}
    @Override
    public Actor oneActor(Long id) {

        return actorRepository.getOne(id);

    }



}

