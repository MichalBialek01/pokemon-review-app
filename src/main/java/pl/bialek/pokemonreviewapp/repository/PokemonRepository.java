package pl.bialek.pokemonreviewapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bialek.pokemonreviewapp.entities.PokemonEntity;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity,Integer> {

}
