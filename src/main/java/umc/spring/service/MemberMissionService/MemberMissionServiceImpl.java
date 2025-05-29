package umc.spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.MissionHandler;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.Mission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.MissionRepository.MissionRepository;
import umc.spring.web.dto.Mission.MemberMissionRequestDTO;

// 왜 여기에 Service을 붙여야하는거지? 이게 어떻게 되는거지
@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements  MemberMissionService {

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    public MemberMission createMemberMission (MemberMissionRequestDTO.CreateDTO request) {
        // member가 있는지 확인 mission이 있는지 확인
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(()-> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(()-> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        MemberMission newMemberMission = MemberMissionConverter.toMemberMission(request);

        newMemberMission.setMember(member);
        newMemberMission.setMission(mission);

        return memberMissionRepository.save(newMemberMission);
    }
}
