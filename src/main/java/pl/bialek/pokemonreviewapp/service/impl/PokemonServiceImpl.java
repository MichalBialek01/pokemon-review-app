package pl.bialek.pokemonreviewapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.bialek.pokemonreviewapp.dto.PokemonDTO;
import pl.bialek.pokemonreviewapp.dto.PokemonResponse;
import pl.bialek.pokemonreviewapp.entities.PokemonEntity;
import pl.bialek.pokemonreviewapp.mappers.PokemonMapUtil;
import pl.bialek.pokemonreviewapp.repository.PokemonRepository;
import pl.bialek.pokemonreviewapp.service.PokemonService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;
    @Override
    public PokemonResponse getAllPokoemons(int pageNumber, int pageCapacity) {
        Pageable pageable = PageRequest.of(pageNumber,pageCapacity);
        Page<PokemonEntity> pokemons = pokemonRepository.findAll(pageable);

        List<PokemonEntity> listOfPokemon = pokemons.getContent();
        List<PokemonDTO> content = listOfPokemon
                .stream()
                .map(PokemonMapUtil::mapToDTO)
                .toList();

        return PokemonResponse.builder()
                .content(content)
                .pageNo(pokemons.getNumber())
                .pageSize(pokemons.getSize())
                .totalElements(pokemons.getTotalElements())
                .totalPages(pokemons.getTotalPages())
                .last(pokemons.isLast())
                .build();
    }

    @Override
    public PokemonDTO getPokemonById(int pokemonId) {
        return null;
    }

    @Override
    public PokemonDTO updatePokemon(PokemonDTO pokemonDto, int pokemonId) {
        return null;
    }

    @Override
    public ResponseEntity deletePokemonId(int pokemonId) {
        return null;
    }
}
