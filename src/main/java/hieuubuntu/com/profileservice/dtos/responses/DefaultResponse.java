package hieuubuntu.com.profileservice.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultResponse<T> {
    private String message = "Thành công";
    private int code = 200;
    private Boolean success = true;
    private T data;
}
