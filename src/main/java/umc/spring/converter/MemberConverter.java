package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.Member.MemberRequestDTO;
import umc.spring.web.dto.Member.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .email(request.getEmail())
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.ReviewPreviewDTO reviewPreviewDTO(Review review){
        return MemberResponseDTO.ReviewPreviewDTO.builder()
                .memberNickName(review.getMember().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static MemberResponseDTO.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList){

        List<MemberResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(MemberConverter::reviewPreviewDTO).collect(Collectors.toList());

        return MemberResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewList(reviewPreviewDTOList)
                .build();
    }

    public static MemberResponseDTO.MissionPreViewDTO missionPreViewDTO(MemberMission memberMission) {
        return MemberResponseDTO.MissionPreViewDTO.builder()
                .reward(memberMission.getMission().getReward())
                .deadline(memberMission.getMission().getDeadline())
                .missionSpec(memberMission.getMission().getMissionSpec())
                .status(memberMission.getStatus())
                .build();
    }


    public static MemberResponseDTO.MissionPreviewListDTO missionPreviewListDTO(Page<MemberMission> memberMissionList) {
        List<MemberResponseDTO.MissionPreViewDTO> memberMissionDTOList = memberMissionList.stream()
                .map(MemberConverter::missionPreViewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MissionPreviewListDTO.builder()
                .missionPreViewDTOList(memberMissionDTOList)
                .listSize(memberMissionDTOList.size())
                .totalElements(memberMissionList.getTotalElements())
                .isFirst(memberMissionList.isFirst())
                .isLast(memberMissionList.isLast())
                .totalPage(memberMissionList.getTotalPages())
                .build();
    }
}