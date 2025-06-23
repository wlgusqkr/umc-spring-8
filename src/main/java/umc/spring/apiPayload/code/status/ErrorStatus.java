package umc.spring.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apiPayload.ErrorReasonDTO;
import umc.spring.apiPayload.code.BaseErrorCode;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),


    // 멤버 관려 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // 예시,,,
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND, "MISSION4001", "미션이 없습니다"),
    // 음식 카테고리가 없을 때
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "FOOD4001", "FOOD 카테고리가 없습니다"),

    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "STORE40001", "가게가 없습니다"),
    // 지역ID가 없을 때
    TEMP_EXCEPTION(HttpStatus.NOT_FOUND, "REGION", "Region ID가 없습니다."),

    REGION_ID_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001", "Region ID에 맞는 지역이 없습니다."),
    REGION_ID_NOT_FOUND(HttpStatus.NOT_FOUND, "REGION4001", "Region ID에 맞는 지역이 없습니다."),

    PAGE_NUMBER_NEGATIVE(HttpStatus.BAD_REQUEST, "PAGE4001", "PAGE 번호는 양수만 가능합니다."),
    PAGE_NUMBER_NOT_INTEGER(HttpStatus.BAD_REQUEST, "PAGE4002", "PAGE 번호는 정수만 가능합니다.");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}