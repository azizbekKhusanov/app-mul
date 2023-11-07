package uz.pdp.appmultipledb.paylaod;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult<T> {

    private final boolean success;

    private String message;

    private T data;

    private List<ErrorData> errorDataList;

    private ApiResult() {
        this.success = true;
    }

    private ApiResult(T data) {
        this();
        this.data = data;
    }

    private ApiResult(String message){
        this();
        this.message = message;
    }


    private ApiResult(String message, T data){
        this();
        this.message = message;
        this.data = data;
    }

    private ApiResult(List<ErrorData> errors) {
        this.success = false;
        this.errorDataList = errors;
    }

    public static <E> ApiResult<E> successResponse(){
        return new ApiResult<>();
    }

    public static <E> ApiResult<E> successResponse(E data){
        return new ApiResult<>(data);
    }

    public static <E> ApiResult<E> successResponse(String message){
        return new ApiResult<>(message);
    }

    public static <E> ApiResult<E> successResponse(String message, E data){
        return new ApiResult<>(message, data);
    }

    public static <E> ApiResult<E> errorResponse(String msg, int status){
        ErrorData errorData = ErrorData.errorObj(msg, status);
        return new ApiResult<>(List.of(errorData));
    }

    public static <E> ApiResult<E> errorResponse(List<ErrorData> errors){
        return new ApiResult<>(errors);
    }



}