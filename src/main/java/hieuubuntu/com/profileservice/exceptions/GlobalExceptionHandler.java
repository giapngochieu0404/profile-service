package hieuubuntu.com.profileservice.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import hieuubuntu.com.profileservice.dtos.responses.DefaultResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    // Handle lỗi chưa được phân loại:
    ResponseEntity<DefaultResponse> handleUncategorizedException(Exception e) {
        DefaultResponse response = new DefaultResponse();
        response.setCode(ErrorCode.DEFAULT_ERROR.getErrorCode());
        response.setMessage(ErrorCode.DEFAULT_ERROR.getMessage());
        response.setSuccess(false);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    ResponseEntity<DefaultResponse> handleMissingServletRequestParameterException(
            MissingServletRequestParameterException e) {
        DefaultResponse response = new DefaultResponse();
        response.setSuccess(false);
        response.setCode(ErrorCode.INVALID_PARAMS_REQUEST.getErrorCode());
        response.setMessage(e.getParameterName() + " is required");
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<DefaultResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        DefaultResponse response = new DefaultResponse();
        response.setSuccess(false);
        response.setCode(ErrorCode.INVALID_PARAMS_REQUEST.getErrorCode());

        String messageError = ErrorCode.DEFAULT_ERROR.getMessage();
        FieldError fieldError = e.getFieldError();
        if (fieldError != null) {
            messageError = fieldError.getDefaultMessage();
        }
        response.setMessage(messageError);

        return ResponseEntity.badRequest().body(response);
    }
}
