package umc.spring.service.StoreService;

import umc.spring.domain.Store;
import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.Mission;
import umc.spring.web.dto.Store.StoreRequestDTO;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);

//    List<Store> findStoresByNameAndScore(String name, Float score);

    Store createStore(StoreRequestDTO.CreateDTO request);

    Page<Review> getReviewList(Long StoreId, Integer page);

    Page<Mission> getMissionList(Long StoreId, Integer page);
    
}