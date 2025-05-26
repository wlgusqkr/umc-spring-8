package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Store;
import umc.spring.service.StoreService.StoreQueryService;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResposneDTO;

@RestController
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreRestController {

    private final StoreQueryService storeService;

    @PostMapping("/")
    public ApiResponse<StoreResposneDTO.CreateResultDTO> create(@RequestBody @Valid StoreRequestDTO.CreateDTO request) {
        Store store = storeService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateResultStore(store));
    }
}
