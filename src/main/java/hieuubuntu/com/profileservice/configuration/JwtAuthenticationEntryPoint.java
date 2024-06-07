package hieuubuntu.com.profileservice.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import hieuubuntu.com.profileservice.dtos.responses.DefaultResponse;
import hieuubuntu.com.profileservice.exceptions.ErrorCode;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;


public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(
            HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
            throws IOException, ServletException {
        // Catch 401:
        ErrorCode errorCode = ErrorCode.UNAUTHENTICATED;
        response.setStatus(errorCode.getStatusCode().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        DefaultResponse<?> defaultResponse = new DefaultResponse<>();
        defaultResponse.setCode(errorCode.getCode());
        defaultResponse.setMessage(errorCode.getMessage());
        defaultResponse.setSuccess(false);

        ObjectMapper objectMapper = new ObjectMapper();

        response.getWriter().write(objectMapper.writeValueAsString(defaultResponse));

        response.flushBuffer();
    }
}
