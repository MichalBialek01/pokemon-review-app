package pl.bialek.pokemonreviewapp.dto.security;

import lombok.Data;

@Data
public class LoginDTO {
    private String username;
    private String password;
}
