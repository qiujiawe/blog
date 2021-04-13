package pers.qjw.admin.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@AllArgsConstructor
public class UserIllegalArgumentException extends RuntimeException{
    private HttpStatus status;
    private String message;
}
