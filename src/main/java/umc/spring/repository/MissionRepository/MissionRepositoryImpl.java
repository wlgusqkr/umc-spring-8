package umc.spring.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QMember;
import umc.spring.domain.QRegion;
import umc.spring.domain.QStore;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.domain.mapping.QMission;


@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QMember member = QMember.member;
    private final QStore store = QStore.store;
    private final QRegion region = QRegion.region;
    private final EntityManager em;

//    @Override
//    List<?> getMission(int memberId, String missionStatus, Pageable pageable) {
//        QueryFactory<?> = jpaQueryFactory
//                .select(member.point, member.point, member.email,)
//                .from(member)
//                .where(member.id.eq(""))
//        return jpaQueryFactory;
//    }
}
