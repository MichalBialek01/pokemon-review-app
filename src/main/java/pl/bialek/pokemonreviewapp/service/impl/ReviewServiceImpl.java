package pl.bialek.pokemonreviewapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bialek.pokemonreviewapp.dto.ReviewDTO;
import pl.bialek.pokemonreviewapp.entities.PokemonEntity;
import pl.bialek.pokemonreviewapp.entities.ReviewEntity;
import pl.bialek.pokemonreviewapp.exceptions.PokemonNotFoundException;
import pl.bialek.pokemonreviewapp.exceptions.ReviewNotAssignedToPokemonException;
import pl.bialek.pokemonreviewapp.exceptions.ReviewNotFoundException;
import pl.bialek.pokemonreviewapp.mappers.ReviewMapUtil;
import pl.bialek.pokemonreviewapp.repository.PokemonRepository;
import pl.bialek.pokemonreviewapp.repository.ReviewRepository;
import pl.bialek.pokemonreviewapp.service.ReviewService;

import java.util.List;

import static pl.bialek.pokemonreviewapp.mappers.ReviewMapUtil.mapToDTO;
import static pl.bialek.pokemonreviewapp.mappers.ReviewMapUtil.mapToEntity;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final PokemonRepository pokemonRepository;


    @Override
    public List<ReviewDTO> findByPokemonId(int pokemonId) {
        return reviewRepository.findByPokemonId(pokemonId)
                .stream()
                .map(ReviewMapUtil::mapToDTO)
                .toList();
    }

    @Override
    public ReviewDTO getReviewById(int pokemonId, int reviewId) {
        PokemonEntity pokemonEntity = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon with id: [%s] doesn't exist".formatted(pokemonId)));

        ReviewEntity reviewEntity = reviewRepository.findById(reviewId).orElseThrow(
                () -> new ReviewNotFoundException("Review with id: [%s] doesn't exist".formatted(reviewId))
        );

        if (reviewEntity.getPokemon().getId() != pokemonEntity.getId()) {
            throw new ReviewNotAssignedToPokemonException(
                    "This review with id: [%s] isn't assigned to pokemon with id: [%s]".formatted(reviewId, pokemonId)
            );
        }
        return mapToDTO(reviewEntity);
    }

    @Override
    public ReviewDTO createReview(int pokemonId, ReviewDTO reviewDTO) {

        pokemonRepository.findById(pokemonId).orElseThrow(
                ()-> new PokemonNotFoundException("review with id [%s] could not be assigned to pokemon with id [%s], because it doesn't exist".formatted(pokemonId,reviewDTO.getId())));
        ReviewEntity savedReview = reviewRepository.save(mapToEntity(reviewDTO));
        return mapToDTO(savedReview);
    }

}
