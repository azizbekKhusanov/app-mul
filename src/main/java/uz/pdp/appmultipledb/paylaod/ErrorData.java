package uz.pdp.appmultipledb.paylaod;


import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class ErrorData {
    private final String msg;
    private final int status;

    private ErrorData(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    public static ErrorData  errorObj(String msg, int status){
        return new ErrorData(msg, status);
    }

}