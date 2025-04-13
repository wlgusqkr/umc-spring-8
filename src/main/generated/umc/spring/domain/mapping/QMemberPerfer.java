package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberPerfer is a Querydsl query type for MemberPerfer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberPerfer extends EntityPathBase<MemberPerfer> {

    private static final long serialVersionUID = 1253845084L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberPerfer memberPerfer = new QMemberPerfer("memberPerfer");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMemberPerfer(String variable) {
        this(MemberPerfer.class, forVariable(variable), INITS);
    }

    public QMemberPerfer(Path<? extends MemberPerfer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberPerfer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberPerfer(PathMetadata metadata, PathInits inits) {
        this(MemberPerfer.class, metadata, inits);
    }

    public QMemberPerfer(Class<? extends MemberPerfer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.spring.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
    }

}

