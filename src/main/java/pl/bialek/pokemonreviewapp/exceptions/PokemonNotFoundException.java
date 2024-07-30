package pl.bialek.pokemonreviewapp.exceptions;

import java.util.UUID;

public class PokemonNotFoundException extends RuntimeException{
    UUID uuid = UUID.randomUUID();

    public PokemonNotFoundException(String message) {
        super(message);
        this.uuid = uuid;
    }
}
