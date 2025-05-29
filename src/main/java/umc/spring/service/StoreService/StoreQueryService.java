package umc.spring.service.StoreService;

import umc.spring.domain.Store;
import umc.spring.web.dto.Store.StoreRequestDTO;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);

//    List<Store> findStoresByNameAndScore(String name, Float score);

    Store createStore(StoreRequestDTO.CreateDTO request);
}