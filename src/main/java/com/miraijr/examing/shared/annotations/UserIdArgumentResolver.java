package com.miraijr.examing.shared.annotations;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.miraijr.examing.shared.annotations.interfaces.UserId;
import com.miraijr.examing.shared.types.CustomAuthentication;

import org.springframework.web.method.support.HandlerMethodArgumentResolver;

@Aspect
@Component
public class UserIdArgumentResolver implements HandlerMethodArgumentResolver {
  @SuppressWarnings("null")
  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.getParameterAnnotation(UserId.class) != null;
  }

  @SuppressWarnings("null")
  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
      NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
    CustomAuthentication authentication = (CustomAuthentication) SecurityContextHolder.getContext().getAuthentication();
    if (authentication != null && authentication.isAuthenticated()) {
      Long userId = (Long) authentication.getPrincipal();
      return userId;
    }

    return null;
  }
}
