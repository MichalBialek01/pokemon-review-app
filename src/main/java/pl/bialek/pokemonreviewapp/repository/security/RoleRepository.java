package pl.bialek.pokemonreviewapp.repository.security;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bialek.pokemonreviewapp.entities.security.RoleEntity;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    Optional<RoleEntity> findByName(String name);
}
