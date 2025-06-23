package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.Mission;
import umc.spring.web.dto.Store.StoreRequestDTO;

import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);

    Store createStore(StoreRequestDTO.CreateDTO request);

    Page<Review> getReviewList(Long StoreId, Integer page);

    Page<Mission> getMissionList(Long StoreId, Integer page);
    
}