package umc.spring.web.dto.Mission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionRequestDTO {

    @Getter
    public static class CreateDTO {
        @NotNull
        private Long memberId;
        @NotNull
        private Long missionId;
        @NotNull
        private String status;

    }
}
