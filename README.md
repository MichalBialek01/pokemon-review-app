# Pokémon Review App

Pokémon Review App to aplikacja oparta na Spring Boot, która umożliwia użytkownikom przeglądanie oraz recenzowanie Pokémonów. Aplikacja posiada mechanizmy uwierzytelniania użytkowników oraz zarządzania rolami, a także operacje CRUD na Pokémonach i recenzjach.

## Struktura Projektu

### 1. Pliki konfiguracyjne i budowania:
- **`build.gradle`**: Zawiera konfigurację budowania projektu w Gradle, w tym zależności, wtyczki oraz zadania do budowania projektu.
- **`settings.gradle`**: Definiuje ustawienia projektu, w tym nazwę głównego projektu.
- **Gradle Wrapper**:
  - `gradlew`, `gradlew.bat`, `gradle-wrapper.jar`, `gradle-wrapper.properties`: Pomaga zarządzać wersją Gradle używaną do budowania projektu, zapewniając spójność na różnych środowiskach.
- **`.gitignore`**: Określa, które pliki i katalogi powinny być ignorowane przez Git.

### 2. Kod źródłowy (`src/main/java`):
- **Główna klasa aplikacji**:
  - `PokemonReviewAppApplication.java`: Punkt wejściowy aplikacji Spring Boot.
  
- **Kontrolery**: Obsługują przychodzące żądania HTTP:
  - `PokemonController.java`: Zarządza operacjami związanymi z Pokémonami (np. wyświetlanie listy, dodawanie i pobieranie danych o Pokémonach).
  - `ReviewController.java`: Zarządza operacjami związanymi z recenzjami, takimi jak dodawanie lub pobieranie recenzji dla konkretnego Pokémona.
  - `AuthController.java`: Obsługuje operacje uwierzytelniania (np. logowanie i rejestrację użytkowników).

- **DTO (Obiekty transferu danych)**: Upraszczają przesyłanie danych między warstwami:
  - `PokemonDTO.java`, `ReviewDTO.java`, `PokemonResponse.java`: Definiują strukturę danych związanych z Pokémonami i recenzjami, które będą przesyłane w odpowiedziach i żądaniach API.
  - DTO związane z bezpieczeństwem: `AuthResponseDTO.java`, `LoginDTO.java`, `RegisterDTO.java` do zarządzania danymi związanymi z uwierzytelnianiem.

- **Repozytoria**:
  - `PokemonRepository.java`, `ReviewRepository.java`, `RoleRepository.java`, `UserRepository.java`: Dostarczają interfejsy do dostępu do danych i komunikacji z bazą danych.

- **Bezpieczeństwo**:
  - `JWTAuthenticationFilter.java`: Filtr, który przechwytuje żądania w celu sprawdzenia ważności tokenów JWT.
  - `JWTGenerator.java`, `JwtAuthEntryPoint.java`: Zarządzają generowaniem i walidacją tokenów JWT dla bezpiecznego uwierzytelniania.
  - `SecurityConfig.java`: Konfiguruje ustawienia bezpieczeństwa, takie jak ograniczenia dostępu do URL, kodowanie haseł i zarządzanie tokenami JWT.

- **Serwisy**:
  - `PokemonService.java`, `ReviewService.java`: Definiują logikę biznesową dla Pokémonów i recenzji.
  - `PokemonServiceImpl.java`, `ReviewServiceImpl.java`: Implementują logikę biznesową, komunikując się z repozytoriami w celu zarządzania bazą danych.

### 3. Zasoby (`src/main/resources`):
- **`application.properties`**: Zawiera ustawienia konfiguracyjne, takie jak szczegóły połączenia z bazą danych oraz inne właściwości specyficzne dla środowiska.
- **`init_acounts_roles.sql`**: Skrypt SQL, który prawdopodobnie inicjuje role użytkowników i konta przy uruchamianiu aplikacji.

### 4. Testy (`src/test/java`):
- **`PokemonReviewAppApplicationTests.java`**: Zawiera przypadki testowe dla aplikacji, zapewniając, że kluczowe funkcjonalności działają zgodnie z oczekiwaniami.

## Kluczowe Funkcjonalności
- **System Recenzji Pokémonów**: Użytkownicy mogą dodawać i pobierać dane o Pokémonach, a inni użytkownicy mogą recenzować te Pokémony. Interakcje te są obsługiwane przez odpowiednie kontrolery (`PokemonController` i `ReviewController`).
- **Uwierzytelnianie Użytkowników**: Aplikacja zawiera funkcje rejestracji i logowania użytkowników zarządzane przez `AuthController`, wykorzystując JWT do bezpiecznego uwierzytelniania.
- **Kontrola Dostępu na Bazie Ról**: Dzięki repozytoriom i implementacjom serwisów zarządzane są role użytkowników w celu ograniczenia dostępu do określonych punktów końcowych.
- **Interakcja z Bazą Danych**: Aplikacja komunikuje się z bazą danych za pomocą repozytoriów do wykonywania operacji CRUD na Pokémonach, recenzjach, użytkownikach i rolach.

## Narzędzia i Technologie
- **Spring Boot**: Framework do budowy API REST oraz zarządzania cyklem życia aplikacji.
- **JWT (JSON Web Tokens)**: Używane do zabezpieczenia aplikacji i zarządzania uwierzytelnianiem oraz autoryzacją użytkowników.
- **Gradle**: Narzędzie do budowania projektu, zarządzające zależnościami oraz kompilacją.
- **Spring Security**: Zarządza uwierzytelnianiem, autoryzacją oraz konfiguracją bezpieczeństwa.
- **JPA/Hibernate**: Prawdopodobnie używane do persystencji danych i mapowania obiektów Java na tabele bazy danych za pomocą repozytoriów.
- **JUnit**: Do pisania i uruchamiania testów.

## Uruchomienie projektu

1. Sklonuj repozytorium:
   ```bash
   git clone [URL repozytorium]
