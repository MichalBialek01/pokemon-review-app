package pl.bialek.pokemonreviewapp.service;

import org.springframework.http.ResponseEntity;
import pl.bialek.pokemonreviewapp.dto.PokemonDTO;
import pl.bialek.pokemonreviewapp.dto.PokemonResponse;

public interface PokemonService {
    PokemonResponse getAllPokoemons(int pageNumber, int pageCappapageCapacity);

    PokemonDTO getPokemonById(int pokemonId);

    PokemonDTO updatePokemon(PokemonDTO pokemonDto, int pokemonId);

    ResponseEntity deletePokemonId(int pokemonId);
}
