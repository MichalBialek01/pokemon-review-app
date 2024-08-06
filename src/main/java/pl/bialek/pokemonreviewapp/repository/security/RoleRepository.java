package pl.bialek.pokemonreviewapp.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bialek.pokemonreviewapp.entities.security.RoleEntity;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    Optional<RoleEntity> findByName(String name);
}
