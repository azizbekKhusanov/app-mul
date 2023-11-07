package uz.pdp.appmultipledb.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.appmultipledb.document.first.Student;
import uz.pdp.appmultipledb.dto.StudentDTO;
import uz.pdp.appmultipledb.exceptions.AppException;
import uz.pdp.appmultipledb.repository.first.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDTO> getAll() {
        List<Student> all = studentRepository.findAll();
        if (all.isEmpty())
            throw new AppException("This list is empty");

        return all.stream()
                .map(this::mapToStudentDTOFomStudent)
                .toList();
    }

    @Override
    public StudentDTO getById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new AppException("Student not found"));

        return mapToStudentDTOFomStudent(student);
    }

    @Override
    public StudentDTO add(StudentDTO studentDTO) {

        if (studentRepository.findByPhoneNumber(studentDTO.getPhoneNumber()).isEmpty()) {
            throw new AppException("This phone number already exist");
        }


        Student student = mapToStudentDTOFomStudent(studentDTO);

        return mapToStudentDTOFomStudent(studentRepository.save(student));
    }

    @Override
    public StudentDTO edit(Integer id, StudentDTO studentDTO) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new AppException("Student not found"));

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setPhoneNumber(studentDTO.getPhoneNumber());

        return mapToStudentDTOFomStudent(studentRepository.save(student));
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.findById(id)
                .orElseThrow(() -> new AppException("Student not found"));
        studentRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {

        if(studentRepository.findAll().isEmpty())
            throw new AppException("This list is empty");
        studentRepository.deleteAll();
    }

    private StudentDTO mapToStudentDTOFomStudent(Student student){

        return StudentDTO.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .phoneNumber(student.getPhoneNumber())
                .build();
    }

    private Student mapToStudentDTOFomStudent(StudentDTO studentDTO){

        return Student.builder()
                .firstName(studentDTO.getFirstName())
                .lastName(studentDTO.getLastName())
                .phoneNumber(studentDTO.getPhoneNumber())
                .build();
    }


}
