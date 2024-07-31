package pl.bialek.pokemonreviewapp.exceptions;

public class ReviewNotAssignedToPokemonException extends RuntimeException {
    public ReviewNotAssignedToPokemonException(String message) {
        super(message);
    }
}
