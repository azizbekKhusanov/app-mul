package uz.pdp.appmultipledb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appmultipledb.dto.BookDTO;
import uz.pdp.appmultipledb.exceptions.AppException;
import uz.pdp.appmultipledb.paylaod.ApiResult;
import uz.pdp.appmultipledb.service.BookService;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class BookControllerImpl implements BookController {

    private final BookService bookService;

    @Override
    public ApiResult<List<BookDTO>> getAll() {

        try {
            List<BookDTO> allList = bookService.getAll();
            return ApiResult.successResponse(allList);
        } catch (AppException e) {
            throw new AppException(e.getMessage(), e.getStatus());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResult<BookDTO> getById(Integer id) {
        try {
            BookDTO bookDTO = bookService.getById(id);
            return ApiResult.successResponse(bookDTO);
        } catch (AppException e) {
            throw new AppException(e.getMessage(), e.getStatus());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResult<BookDTO> create(BookDTO bookDTO) {
        try {
            BookDTO newBookDTO = bookService.add(bookDTO);
            return ApiResult.successResponse(newBookDTO);
        } catch (AppException e) {
            throw new AppException(e.getMessage(), e.getStatus());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResult<BookDTO> edit(Integer id, BookDTO bookDTO) {
        try {
            BookDTO newBookDTO = bookService.edit(id, bookDTO);
            return ApiResult.successResponse(newBookDTO);
        } catch (AppException e) {
            throw new AppException(e.getMessage(), e.getStatus());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }    }

    @Override
    public ApiResult<?> deleteAById(Integer id) {
        try {
            bookService.deleteById(id);
            return ApiResult.successResponse("Book deleted");
        } catch (AppException e) {
            throw new AppException(e.getMessage(), e.getStatus());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResult<?> deleteAll() {
        try {
            bookService.deleteAll();
            return ApiResult.successResponse("All books deleted");
        } catch (AppException e) {
            throw new AppException(e.getMessage(), e.getStatus());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
