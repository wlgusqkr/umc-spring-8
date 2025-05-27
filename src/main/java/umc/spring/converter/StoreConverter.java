package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.Store.StoreRequestDTO;
import umc.spring.web.dto.Store.StoreResposneDTO;

public class StoreConverter {

    public static StoreResposneDTO.CreateResultDTO toCreateResultStore(Store store) {

        return StoreResposneDTO.CreateResultDTO.builder()
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
}
