package hieuubuntu.com.profileservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DEFAULT_ERROR(1000, "Có lỗi xảy ra vui lòng liên hệ admin", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_PARAMS_REQUEST(1001, "Tham số không hợp lệ", HttpStatus.BAD_REQUEST);

    private int errorCode;
    private String message;
    private HttpStatusCode statusCode;
}
