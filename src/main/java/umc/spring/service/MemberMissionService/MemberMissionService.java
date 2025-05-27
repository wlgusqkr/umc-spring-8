package umc.spring.service.MemberMissionService;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.Mission.MemberMissionRequestDTO;

public interface MemberMissionService {
    public MemberMission createMemberMission (MemberMissionRequestDTO.CreateDTO request);
}
