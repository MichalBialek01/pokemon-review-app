package pl.bialek.pokemonreviewapp.controllers;

import lombok.RequiredArgsConstructor;
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
    public List<ReviewDTO> getPokemonReviewById(
            @PathVariable("pokemonId") int pokemonId
    ){
        return reviewService.findByPokemonId(pokemonId);
    }


}
