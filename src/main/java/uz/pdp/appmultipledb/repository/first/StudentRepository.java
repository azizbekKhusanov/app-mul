package uz.pdp.appmultipledb.repository.first;

import org.springframework.data.mongodb.repository.MongoRepository;
import uz.pdp.appmultipledb.document.first.Student;

import java.util.Optional;


public interface StudentRepository extends MongoRepository<Student, Integer> {

    Optional<Student> findByPhoneNumber(String phoneNumber);

}
