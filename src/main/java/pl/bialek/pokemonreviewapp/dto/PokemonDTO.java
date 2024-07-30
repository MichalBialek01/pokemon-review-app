package pl.bialek.pokemonreviewapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonDTO {
    private int id;
    private String name;
    private String type;

}
