package uz.pdp.appmultipledb.service;


import uz.pdp.appmultipledb.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    List<StudentDTO> getAll();

    StudentDTO getById(Integer id);

    StudentDTO add(StudentDTO studentDTO);

    StudentDTO edit(Integer id, StudentDTO studentDTO);

    void deleteById(Integer id);

    void deleteAll();

}
