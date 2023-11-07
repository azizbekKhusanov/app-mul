package uz.pdp.appmultipledb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.appmultipledb.dto.StudentDTO;
import uz.pdp.appmultipledb.exceptions.AppException;
import uz.pdp.appmultipledb.paylaod.ApiResult;
import uz.pdp.appmultipledb.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController {

    private final StudentService studentService;

    @Override
    public ApiResult<List<StudentDTO>> getAll() {

        try {
            List<StudentDTO> all = studentService.getAll();

            return ApiResult.successResponse(all);
        } catch (AppException e) {
            throw new AppException(e.getMessage(), e.getStatus());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResult<StudentDTO> getById(Integer id) {
        try {
            StudentDTO studentDTO = studentService.getById(id);

            return ApiResult.successResponse(studentDTO);
        } catch (AppException e) {
            throw new AppException(e.getMessage(), e.getStatus());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResult<StudentDTO> create(StudentDTO studentDTO) {
        try {
            StudentDTO createdStudentDTO = studentService.add(studentDTO);

            return ApiResult.successResponse(createdStudentDTO);
        } catch (AppException e) {
            throw new AppException(e.getMessage(), e.getStatus());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResult<StudentDTO> edit(Integer id, StudentDTO studentDTO) {
        try {
            StudentDTO editedStudentDTO = studentService.edit(id, studentDTO);

            return ApiResult.successResponse(editedStudentDTO);
        } catch (AppException e) {
            throw new AppException(e.getMessage(), e.getStatus());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResult<?> deleteById(Integer id) {
        try {
             studentService.deleteById(id);

            return ApiResult.successResponse("No content");
        } catch (AppException e) {
            throw new AppException(e.getMessage(), e.getStatus());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ApiResult<?> deleteAll() {
        try {
            studentService.deleteAll();

            return ApiResult.successResponse("No content");
        } catch (AppException e) {
            throw new AppException(e.getMessage(), e.getStatus());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
