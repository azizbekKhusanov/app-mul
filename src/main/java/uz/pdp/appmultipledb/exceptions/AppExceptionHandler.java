package uz.pdp.appmultipledb.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uz.pdp.appmultipledb.paylaod.ApiResult;
import uz.pdp.appmultipledb.paylaod.ErrorData;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ApiResult<List<ErrorData>>> handle(AppException e) {

        return ResponseEntity.status(HttpStatus.FORBIDDEN.value())
                .body(ApiResult.errorResponse(e.getMessage(), HttpStatus.FORBIDDEN.value()));

    }

    @ExceptionHandler
    public ResponseEntity<ApiResult<List<ErrorData>>> handle(Exception e) {

        List<ErrorData> errorDataList = new ArrayList<>();

        errorDataList.add(ErrorData.errorObj(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()));


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiResult.errorResponse(errorDataList));

    }

}
