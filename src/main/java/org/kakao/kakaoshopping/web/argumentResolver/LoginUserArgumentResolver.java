package org.kakao.kakaoshopping.web.argumentResolver;

import org.kakao.kakaoshopping.web.annotaion.LoginUser;
import org.kakao.kakaoshopping.web.dto.member.login.LoggedInUser;
import org.springframework.core.MethodParameter;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// 컨트롤러의 파라미터를 체크하는데 내부적으로 캐시가 동작하여 한 번 체크하면 다음부터는 캐시에 저장된 값을 사용함
		boolean hasLoginAnnotation = parameter.hasParameterAnnotation(LoginUser.class);
		boolean hasLoginUserType = LoggedInUser.class.isAssignableFrom(parameter.getParameterType());

		return hasLoginAnnotation && hasLoginUserType;
	}

	@Override
	public Object resolveArgument(@NonNull MethodParameter parameter, ModelAndViewContainer mavContainer,
		@NonNull NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {

		//long userId = Long.parseLong(webRequest.getParameter("id"));
		long userId = 0L;

		return LoggedInUser.builder()
			.userId(userId)
			.build();
	}
}