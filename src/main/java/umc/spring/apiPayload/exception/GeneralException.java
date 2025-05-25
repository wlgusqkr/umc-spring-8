    package umc.spring.apiPayload.exception;

    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import umc.spring.apiPayload.ErrorReasonDTO;
    import umc.spring.apiPayload.code.BaseErrorCode;

    @Getter
    @AllArgsConstructor
    public class GeneralException extends RuntimeException {

        private BaseErrorCode code;

        public ErrorReasonDTO getErrorReason() {
            return this.code.getReason();
        }

        public ErrorReasonDTO getErrorReasonHttpStatus(){
            return this.code.getReasonHttpStatus();
        }
    }