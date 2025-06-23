package umc.spring.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.spring.repository.MemberRepository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;


@Service
@Transactional
@RequiredArgsConstructor
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;

    public Page<Review> getReviewList(Long memberId, Integer page) {

        Member member = memberRepository.findById(memberId).get();

        Page<Review> MemberReviewPage = reviewRepository.findAllByMember(member, PageRequest.of(page, 10));

        return MemberReviewPage;
    }

    public Page<MemberMission> getMissionList(Long memberId, Integer page) {

        Page<MemberMission> memberMissionList = memberMissionRepository.findAllByMemberId(memberId, PageRequest.of(page, 10));

        return memberMissionList;
    }
}
