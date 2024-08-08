package pl.bialek.pokemonreviewapp.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import pl.bialek.pokemonreviewapp.entities.PokemonEntity;

import java.util.List;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DataJpaTest
@ActiveProfiles("test")
class PokemonRepositoryTest {




    @Autowired
    private PokemonRepository pokemonRepository;

    @AfterEach
    public void cleanUpDatabase() {
//        TODO
    }

    @Test
    public void PokemonRepository_SaveAll_ReturnSavedPokemon() {
        // Given/Arrange
        PokemonEntity testingPokemon = PokemonEntity.builder()
                .name("PokemonName")
                .type("PokemonType")
                .build();
        // When/Act
        PokemonEntity savedPokemon = pokemonRepository.save(testingPokemon);

        // Then/Assert
        Assertions.assertThat(savedPokemon).isNotNull();
        Assertions.assertThat(savedPokemon.getId()).isGreaterThan(0);
    }

    @Test
    public void PokemonRepository_GetAll_ReturnInsertedPokemon() {
        // Given/Arrange
        PokemonEntity pokemon1 = PokemonEntity.builder()
                .name("pokemonName1")
                .type("pokemonType1")
                .build();

        PokemonEntity pokemon2 = PokemonEntity.builder()
                .name("pokemonName2")
                .type("pokemonType2")
                .build();

        pokemonRepository.save(pokemon1);
        pokemonRepository.save(pokemon2);

        // When/Act
        List<PokemonEntity> savedPokemon = pokemonRepository.findAll();

        // Then/Assert
        Assertions.assertThat(savedPokemon).isNotNull();
        Assertions.assertThat(savedPokemon.size()).isEqualTo(2);
    }

    @Test
    public void PokemonRepository_FindById_ReturnsPokemon() {
        // Given/Arrange
        PokemonEntity pokemon = PokemonEntity.builder()
                .name("pokemonName1")
                .type("pokemonType1")
                .build();

        // When/Act
        pokemonRepository.save(pokemon);
        PokemonEntity retrievedFromDBPokemon = pokemonRepository.findById(pokemon.getId()).get();


        // Then/Assert
        Assertions.assertThat(retrievedFromDBPokemon).isNotNull();
        Assertions.assertThat(retrievedFromDBPokemon).isEqualTo(1);
    }


}