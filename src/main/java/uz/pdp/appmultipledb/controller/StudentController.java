package uz.pdp.appmultipledb.controller;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appmultipledb.dto.StudentDTO;
import uz.pdp.appmultipledb.paylaod.ApiResult;

import java.util.List;

@RequestMapping("/api-students")
public interface StudentController {

    @GetMapping
    ApiResult<List<StudentDTO>> getAll();

    @GetMapping("/{id}")
    ApiResult<StudentDTO> getById(@PathVariable Integer id);

    @PostMapping
    ApiResult<StudentDTO> create(@Valid @RequestBody StudentDTO studentDTO);


    @PutMapping("/edit/{id}")
    ApiResult<StudentDTO> edit(@PathVariable Integer id,
                               @Valid @RequestBody StudentDTO studentDTO);

    @DeleteMapping("/delete/{id}")
    ApiResult<?> deleteById(@PathVariable Integer id);

    @DeleteMapping("/deleteAll")
    ApiResult<?> deleteAll();



}
