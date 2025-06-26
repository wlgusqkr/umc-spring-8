package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.aws.s3.AmazonS3Manager;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.Uuid;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;
import umc.spring.repository.UuidRepository.UuidRepository;
import umc.spring.web.dto.Review.ReviewRequestDTO;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final AmazonS3Manager s3Manager;
    private final UuidRepository uuidRepository;
    public Review createReview(ReviewRequestDTO.createDTO request) {

        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(()-> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        String uuid = UUID.randomUUID().toString();

        Uuid savedUuid = uuidRepository.save(Uuid.builder().uuid(uuid).build());

        try {
            String pictureUrl = s3Manager.uploadFile(s3Manager.generateReviewKeyName(savedUuid), request.getImage());
        } catch (Exception e) {
            System.out.println(e);
        }



        Review newReview = ReviewConverter.toReview(request);

        newReview.setStore(store);
        newReview.setMember(member);

        return reviewRepository.save(newReview);

    }
}
