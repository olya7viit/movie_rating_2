package by.matusevichChercasova.movieRating.service.impl;

import by.matusevichChercasova.movieRating.dto.RatingDto;
import by.matusevichChercasova.movieRating.dto.mapper.RatingMapper;
import by.matusevichChercasova.movieRating.entity.Rating;
import by.matusevichChercasova.movieRating.repository.RatingRepository;
import by.matusevichChercasova.movieRating.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    private final RatingMapper ratingMapper;
    private final RatingRepository ratingRepository;

    @Autowired
    public RatingServiceImpl(RatingMapper ratingMapper, RatingRepository ratingRepository) {
        this.ratingMapper = ratingMapper;
        this.ratingRepository = ratingRepository;
    }

    @Override
    public boolean saveRating(RatingDto ratingDto) {
        Rating rating = ratingMapper.toEntity(ratingDto);

        ratingRepository.save(rating);

        return true;
    }

    @Override
    public long isRatingExists(RatingDto ratingDto) {
        long idRating = -1;
        List<Rating> list = ratingRepository.findAll();

        for (int i=0;i<list.size();i++){

            if(list.get(i).getIdUser() == ratingDto.getIdUser() &&
            list.get(i).getIdFilm() == ratingDto.getIdFilm()){
                idRating = list.get(i).getId();
            }
        }
        return idRating;
    }

    @Override
    public void updateRating(RatingDto ratingDto) {
        Rating rating = ratingMapper.toEntity(ratingDto);
        rating.setId(ratingDto.getId());
        ratingRepository.deleteById(rating.getId());
        ratingRepository.save(rating);

    }
    @Override
    public  double oneFilmRating(Long idFilm) {
        double rating=0.0;
        List<Rating> ratings =ratingRepository.findAllByIdFilm(idFilm);
        for (Rating i:ratings) {
            rating+=i.getValue();
        }
        if(ratings.size()!=0){
        rating/=ratings.size();
        }

        return rating;
    }
}
