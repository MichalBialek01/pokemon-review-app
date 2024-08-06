package pl.bialek.pokemonreviewapp.repository.security;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bialek.pokemonreviewapp.entities.security.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);

    Boolean existByUsername(String username);
}
