package umc.spring.web.dto.Review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewResponseDTO {


    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createResultDTO {

        Long reviewId;

        Long memberId;

        Long storeId;

        String body;

        Float score;

    }
}
