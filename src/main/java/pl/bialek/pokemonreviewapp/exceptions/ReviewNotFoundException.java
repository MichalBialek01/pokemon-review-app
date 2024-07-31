package pl.bialek.pokemonreviewapp.exceptions;

import java.util.UUID;

public class ReviewNotFoundException extends RuntimeException {
    UUID uuid = UUID.randomUUID();

    public ReviewNotFoundException(String message) {
        super(message);
        this.uuid = uuid;
    }
}
