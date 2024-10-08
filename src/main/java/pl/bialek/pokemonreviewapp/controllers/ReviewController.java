package pl.bialek.pokemonreviewapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bialek.pokemonreviewapp.dto.ReviewDTO;
import pl.bialek.pokemonreviewapp.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("pokemon/{pokemonId}/reviews")
    public List<ReviewDTO> getPokemonReviewByPokemonId(
            @PathVariable("pokemonId") int pokemonId
    ) {
        return reviewService.findByPokemonId(pokemonId);
    }

    @GetMapping("pokemon/{pokemonId}/reviews/{reviewId}")
    public ResponseEntity<ReviewDTO> getReviewById(
            @PathVariable("pokemonId") int pokremonId,
            @PathVariable("reviewId") int reviewId
    ) {
        ReviewDTO review = reviewService.getReviewById(pokremonId, reviewId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PostMapping("pokemon/{pokemonId}/reviews")
    public ResponseEntity<ReviewDTO> createReview(
            @PathVariable("pokemonId") int pokemonId,
            @RequestBody ReviewDTO reviewDTO
    ) {
        ReviewDTO savedReview = reviewService.createReview(pokemonId, reviewDTO);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }

    @PutMapping("pokemon/{pokemonId}/reviews/{reviewId}")
    public ResponseEntity<ReviewDTO> updateReview(
            @PathVariable("pokemonId") int pokemonId,
            @PathVariable("reviewId") int reviewId,
            @RequestBody ReviewDTO reviewDTO
    ) {
        ReviewDTO savedReview = reviewService.updateReview(pokemonId, reviewId, reviewDTO);
        return new ResponseEntity<>(savedReview, HttpStatus.OK);
    }

    @DeleteMapping("/pokemon/{pokemonId}/reviews/{id}")
    public ResponseEntity<String> deleteReview(
            @PathVariable(value = "pokemonId") int pokemonId,
            @PathVariable(value = "id") int reviewId
    ){
        reviewService.deleteReview(pokemonId, reviewId);
        return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
    }

}
