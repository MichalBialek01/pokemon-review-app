package pl.bialek.pokemonreviewapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bialek.pokemonreviewapp.entities.ReviewEntity;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity,Integer> {
    List<ReviewEntity> findByPokemonId(int pokemonId);
}
