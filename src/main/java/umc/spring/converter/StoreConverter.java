package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.Mission;
import umc.spring.web.dto.Store.StoreRequestDTO;
import umc.spring.web.dto.Store.StoreResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static StoreResponseDTO.CreateResultDTO toCreateResultStore(Store store) {

        return StoreResponseDTO.CreateResultDTO.builder()
                .name(store.getName())
                .id(store.getId())
                .build();
    }
    public static Store toStore(StoreRequestDTO.CreateDTO request) {

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .score(request.getScore())
                .build();
    }

    // Entity to DTO
    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    // Entity to DTO List
    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static StoreResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission) {

        return StoreResponseDTO.MissionPreViewDTO.builder()
                .missionId(mission.getId())
                .reward(mission.getReward())
                .missionSpec(mission.getMissionSpec())
                .deadline(mission.getDeadline())
                .build();
    }

    public static StoreResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList) {
        List<StoreResponseDTO.MissionPreViewDTO> missionPreViewDTO = missionList.stream()
                .map(StoreConverter::missionPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.MissionPreViewListDTO.builder()
                .missionList(missionPreViewDTO)
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .listSize(missionPreViewDTO.size())
                .build();
    }

}
