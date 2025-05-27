package umc.spring.converter;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.Mission.MemberMissionRequestDTO;
import umc.spring.web.dto.Mission.MemberMissionResponseDTO;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(MemberMissionRequestDTO.CreateDTO request) {
        return MemberMission.builder()
                .status(request.getStatus())
                .build();
    }
    public static MemberMissionResponseDTO.CreateResultDTO toCreateResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.CreateResultDTO.builder()
                .memberId(memberMission.getMission().getId())
                .missionId(memberMission.getMission().getId())
                .status(memberMission.getStatus())
                .build();
    }
}
