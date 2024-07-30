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
import pl.bialek.pokemonreviewapp.exceptions.PokemonNotFoundException;
import pl.bialek.pokemonreviewapp.mappers.PokemonMapUtil;
import pl.bialek.pokemonreviewapp.repository.PokemonRepository;
import pl.bialek.pokemonreviewapp.service.PokemonService;

import java.util.List;

import static pl.bialek.pokemonreviewapp.mappers.PokemonMapUtil.mapToDTO;

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
        PokemonEntity pokemonEntity = pokemonRepository.findById(pokemonId).orElseThrow(
                () -> new PokemonNotFoundException("Pokemon with provided id [%s] doesn't exist".formatted(pokemonId))
        );
        return mapToDTO(pokemonEntity);
    }

    @Override
    public PokemonDTO updatePokemon(PokemonDTO pokemonDto, int pokemonId) {
        PokemonEntity pokemonEntity = pokemonRepository.findById(pokemonId).orElseThrow(
                () -> new PokemonNotFoundException("Pokemon with provided id [%s] doesn't exist".formatted(pokemonId))
        );
        pokemonEntity.setName(pokemonDto.getName());
        pokemonEntity.setType(pokemonDto.getType());

        PokemonEntity savedPokemon = pokemonRepository.save(pokemonEntity);
        return mapToDTO(savedPokemon);
    }

    @Override
    public ResponseEntity deletePokemonId(int pokemonId) {
        PokemonEntity pokemonEntity = pokemonRepository.findById(pokemonId).orElseThrow(
                () -> new PokemonNotFoundException("Pokemon with provided id [%s] doesn't exist".formatted(pokemonId))
        );
        pokemonRepository.delete(pokemonEntity);
        return ResponseEntity.ok().build();
    }
}
