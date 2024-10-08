package pl.bialek.pokemonreviewapp.service;

import pl.bialek.pokemonreviewapp.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> findByPokemonId(int pokemonId);

    ReviewDTO getReviewById(int pokremonId, int reviewId);

    ReviewDTO createReview(int pokemonId, ReviewDTO reviewDTO);

    ReviewDTO updateReview(int pokemonId, int reviewId, ReviewDTO reviewDTO);

    void deleteReview(int pokemonId, int reviewId);
}
