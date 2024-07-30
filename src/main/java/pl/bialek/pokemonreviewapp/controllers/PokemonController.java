package pl.bialek.pokemonreviewapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bialek.pokemonreviewapp.dto.PokemonDTO;
import pl.bialek.pokemonreviewapp.dto.PokemonResponse;
import pl.bialek.pokemonreviewapp.service.PokemonService;


@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class PokemonController {

    PokemonService pokemonService;


    @GetMapping("pokemons")
    public ResponseEntity<PokemonResponse> getPokemons(
            @RequestParam(value = "pageNumber", defaultValue = "0") int pageNumber,
            @RequestParam(value = "pageCapacity", defaultValue = "10") int pageCappapageCapacity
    ){
        return new ResponseEntity<>(pokemonService.getAllPokoemons(pageNumber,pageCappapageCapacity),
                HttpStatus.OK);
    }

    @GetMapping("pokemon/{id}")
    public ResponseEntity<PokemonDTO> getPokemon(
            @PathVariable("pokemonId") int pokemonId
    ){
        return ResponseEntity.ok(pokemonService.getPokemonById(pokemonId));
    }

    @PutMapping("pokemon/{id}/update")
    public ResponseEntity<PokemonDTO> updatePokemon(
            @RequestBody PokemonDTO pokemonDto,
            @PathVariable("id") int pokemonId) {
        PokemonDTO response = pokemonService.updatePokemon(pokemonDto, pokemonId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(
            @PathVariable("id") int pokemonId
    ) {
        pokemonService.deletePokemonId(pokemonId);
        return new ResponseEntity<>("Pokemon delete", HttpStatus.OK);
    }


}
