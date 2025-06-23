package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberMissionService.MemberMissionService;
import umc.spring.web.dto.Mission.MemberMissionRequestDTO;
import umc.spring.web.dto.Mission.MemberMissionResponseDTO;

@RequestMapping("/memberMission")
@RequiredArgsConstructor
@RestController
public class MemberMissionRestController {


    private final MemberMissionService memberMissionService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.CreateResultDTO> create(@RequestBody @Valid MemberMissionRequestDTO.CreateDTO request) {

        MemberMission memberMission = memberMissionService.createMemberMission(request);

        return ApiResponse.onSuccess(MemberMissionConverter.toCreateResultDTO(memberMission));
    }

}
