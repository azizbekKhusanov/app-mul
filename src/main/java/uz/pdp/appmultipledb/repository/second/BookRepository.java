package uz.pdp.appmultipledb.repository.second;


import org.springframework.data.mongodb.repository.MongoRepository;
import uz.pdp.appmultipledb.document.second.Book;

public interface BookRepository extends MongoRepository<Book, Integer> {

}
