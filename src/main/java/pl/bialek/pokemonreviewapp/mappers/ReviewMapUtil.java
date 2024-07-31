package pl.bialek.pokemonreviewapp.mappers;

import pl.bialek.pokemonreviewapp.dto.ReviewDTO;
import pl.bialek.pokemonreviewapp.entities.ReviewEntity;

public class ReviewMapUtil {
    public static ReviewDTO mapToDTO(ReviewEntity reviewEntity){
        return ReviewDTO.builder()
                .id(reviewEntity.getId())
                .title(reviewEntity.getTitle())
                .content(reviewEntity.getContent())
                .stars(reviewEntity.getStars())
                .build();
    }

    public static ReviewEntity mapToEntity(ReviewDTO reviewDTO){
        return ReviewEntity.builder()
                .id(reviewDTO.getId())
                .title(reviewDTO.getTitle())
                .content(reviewDTO.getContent())
                .stars(reviewDTO.getStars())
                .build();
    }



}
