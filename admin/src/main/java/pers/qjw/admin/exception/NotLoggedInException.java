package pers.qjw.admin.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class NotLoggedInException extends RuntimeException {
    private HttpStatus status;
    private String message;
}
