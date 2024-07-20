package com.miraijr.examing.core.infrastruction.config;

import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miraijr.examing.core.application.ApplicationException;
import com.miraijr.examing.shared.exceptions.ExceptionResponseModel;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ExceptionHandlerFilter extends OncePerRequestFilter {
  private final ObjectMapper objectMapper;

  @SuppressWarnings("null")
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      filterChain.doFilter(request, response);
    } catch (ApplicationException exception) {
      response.setStatus(exception.getStatusCode().value());
      response.setContentType("application/json");
      response.getWriter().write(this.convertToExceptionResponseModel(exception));
    }
  }

  private String convertToExceptionResponseModel(ApplicationException exception) throws JsonProcessingException {
    ExceptionResponseModel exceptionResponseModel = new ExceptionResponseModel(
        exception.getErrorCode(),
        exception.getMessage(),
        exception.getCause() != null ? exception.getCause().getMessage() : exception.getMessage(),
        new Date(),
        exception.getStackTrace());

    return objectMapper.writeValueAsString(exceptionResponseModel);
  }
}
