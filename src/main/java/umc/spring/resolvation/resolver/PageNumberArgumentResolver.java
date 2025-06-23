package umc.spring.resolvation.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.GeneralException;
import umc.spring.resolvation.annotation.PageNumber;

@Component
public class PageNumberArgumentResolver implements HandlerMethodArgumentResolver {


    // 이 리졸버가 지원할 파라미터인지 검사
    // 1. @PageNumber 어노테이션이 붙어있는가?
    // 2. 파라미터 타입이 Integer 또는 int인가?
    @Override
    public boolean supportsParameter(MethodParameter parameter) {

        return parameter.hasParameterAnnotation(PageNumber.class)
                && (parameter.getParameterType().equals(Integer.class)) || parameter.getParameterType().equals(int.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        // supportsParameter가 true를 반환했을 때만 실행됨
        // 실제 파라미터에 바인딩할 값을 만들어서 반환
        String pageNumber = webRequest.getParameter("pageNumber");

        if(pageNumber == null) {
            return 1;
        }

        int page;

        try {
            page = Integer.parseInt(pageNumber);
        } catch (NumberFormatException e) {
            throw new GeneralException(ErrorStatus.PAGE_NUMBER_NOT_INTEGER);
        }

        if(page < 0) {
            throw new GeneralException(ErrorStatus.PAGE_NUMBER_NEGATIVE);
        } else if (page == 0) {
            page = 1;
        } else {
            page = page - 1;
        }

        return page;
    }
}
