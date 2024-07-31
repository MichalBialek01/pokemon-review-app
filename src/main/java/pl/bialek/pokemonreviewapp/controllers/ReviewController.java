package pl.bialek.pokemonreviewapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.bialek.pokemonreviewapp.dto.ReviewDTO;
import pl.bialek.pokemonreviewapp.service.ReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("pokemon/{pokemonId}/reviews")
    public List<ReviewDTO> getPokemonReviewByPokemonId(
            @PathVariable("pokemonId") int pokemonId
    ){
        return reviewService.findByPokemonId(pokemonId);
    }

    @GetMapping("pokemon/{pokremonId}/reviews/{reviewId}")
    public ResponseEntity<ReviewDTO> getReviewById(
            @PathVariable("pokremonId") int pokremonId,
            @PathVariable("reviewId") int reviewId
    ){
        ReviewDTO review = reviewService.getReviewById(pokremonId, reviewId);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }


}
