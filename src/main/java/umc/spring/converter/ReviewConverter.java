package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.web.dto.Review.ReviewRequestDTO;
import umc.spring.web.dto.Review.ReviewResponseDTO;

public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.createDTO request) {
        return Review.builder()
                .body(request.getBody())
                .score(request.getScore())
                .build();

    }
    public static ReviewResponseDTO.createResultDTO toReviewResultDTO(Review review) {
        return ReviewResponseDTO.createResultDTO.builder()
                .body(review.getBody())
                .score(review.getScore())
                .reviewId(review.getId())
                .storeId(review.getStore().getId())
                .memberId(review.getMember().getId())
                .build();
    }
}
