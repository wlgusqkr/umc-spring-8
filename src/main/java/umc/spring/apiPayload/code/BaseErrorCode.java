package umc.spring.apiPayload.code;

import umc.spring.apiPayload.ErrorReasonDTO;

public interface BaseErrorCode {

    ErrorReasonDTO getReason();

    ErrorReasonDTO getReasonHttpStatus();
}
