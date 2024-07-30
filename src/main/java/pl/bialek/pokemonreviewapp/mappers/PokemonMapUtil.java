package pl.bialek.pokemonreviewapp.mappers;

import pl.bialek.pokemonreviewapp.dto.PokemonDTO;
import pl.bialek.pokemonreviewapp.entities.PokemonEntity;

public class PokemonMapUtil {
    public static PokemonEntity mapToEntity(PokemonDTO pokemonDTO){
        return PokemonEntity.builder()
                .name(pokemonDTO.getName())
                .type(pokemonDTO.getType())
                .build();
    }
    public static PokemonDTO mapToDTO(PokemonEntity pokemonEntity){
        return PokemonDTO.builder()
                .id(pokemonEntity.getId())
                .name(pokemonEntity.getName())
                .type(pokemonEntity.getType())
                .build();
    }
}
