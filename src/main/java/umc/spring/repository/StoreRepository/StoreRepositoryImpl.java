package umc.spring.repository.StoreRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom {

//    private final JPAQueryFactory jpaQueryFactory;
//    private final QStore store = QStore.store;
//
//    @Override
//    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score) {
//        BooleanBuilder predicate = new BooleanBuilder();
//
//        if (name != null) {
//            predicate.and(store.name.eq(name));
//        }
//
//        if(score != null) {
//            predicate.and(store.score.goe(4.0f));
//        }
//        return jpaQueryFactory
//                .selectFrom(store)
//                .where(predicate)
//                .fetch();
//    }

}
