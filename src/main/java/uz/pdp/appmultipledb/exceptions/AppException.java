package uz.pdp.appmultipledb.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;


@Getter
@ToString
@NoArgsConstructor
public class AppException extends RuntimeException {

    private String message;

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public AppException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public AppException(String message) {
        this.message = message;
    }

}
