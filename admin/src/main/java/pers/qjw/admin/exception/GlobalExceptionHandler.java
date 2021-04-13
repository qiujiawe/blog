package pers.qjw.admin.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = NotLoggedInException.class)
    public ResponseEntity<String> NotLoggedInException(NotLoggedInException e) {
        return new ResponseEntity<>(e.getMessage(),e.getStatus());
    }

    @ExceptionHandler(value = UserIllegalArgumentException.class)
    public ResponseEntity<String> UserIllegalArgumentException(UserIllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(),e.getStatus());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e) {
        logger.error("未知异常！原因是:", e);
        return new ResponseEntity<>("服务器出现未知异常", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
