package by.matusevichChercasova.movieRating.service.impl;

import by.matusevichChercasova.movieRating.dto.ActorDto;
import by.matusevichChercasova.movieRating.dto.mapper.ActorMapper;
import by.matusevichChercasova.movieRating.entity.Actor;
import by.matusevichChercasova.movieRating.entity.Film;
import by.matusevichChercasova.movieRating.repository.ActorRepository;
import by.matusevichChercasova.movieRating.repository.FilmRepository;
import by.matusevichChercasova.movieRating.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
public class ActorServiceImpl implements ActorService {
    private FilmRepository filmRepository;
    private ActorRepository actorRepository;
    private ActorMapper actorMapper;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository, ActorMapper actorMapper, FilmRepository filmRepository) {

        this.actorRepository = actorRepository;
        this.actorMapper = actorMapper;
        this.filmRepository = filmRepository;
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
    public void updateActor(ActorDto actorDto) {

       Actor actor = actorMapper.toEntity(actorDto);

        actorRepository.save(actor);
    }

    @Override
    public List<Actor> getActorsFromFilm(Long idFilm) {

        List<Actor> actors = actorRepository.findAll();
        List<Actor> correctActors = new ArrayList<>();
        Film film = filmRepository.findById(idFilm).get();

        Set<Film> filmSet;

        /*for (int i=0;i<actors.size();i++){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            filmSet = actors.get(i).getFilms();
            System.out.println(filmSet);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            if(filmSet.contains(film)){
                System.out.println("222222222222222222222222222222222222222222");
                System.out.println(actors.get(i));
                System.out.println("222222222222222222222222222222222222222222");
                correctActors.add(actors.get(i));
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");*/

        return correctActors;
    }

    @Override
    public List<ActorDto> allActors() {
        List<Actor> actors = actorRepository.findAll();
        return actorMapper.toDtoList(actors);
    }

    @Override
    public Actor oneActor(Long id) {
        return actorRepository.getOne(id);
    }

}

