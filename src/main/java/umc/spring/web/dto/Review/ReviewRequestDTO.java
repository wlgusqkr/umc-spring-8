package umc.spring.web.dto.Review;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

public class ReviewRequestDTO {

    @Getter
    public static class createDTO {

        Long memberId;

        Long storeId;

        String body;

        Float score;

        MultipartFile image;

    }
}
