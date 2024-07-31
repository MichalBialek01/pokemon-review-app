package pl.bialek.pokemonreviewapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bialek.pokemonreviewapp.dto.ReviewDTO;
import pl.bialek.pokemonreviewapp.entities.ReviewEntity;
import pl.bialek.pokemonreviewapp.mappers.ReviewMapUtil;
import pl.bialek.pokemonreviewapp.repository.PokemonRepository;
import pl.bialek.pokemonreviewapp.repository.ReviewRepository;
import pl.bialek.pokemonreviewapp.service.ReviewService;

import java.util.List;

import static pl.bialek.pokemonreviewapp.mappers.ReviewMapUtil.mapToDTO;


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

}
