package uz.pdp.appmultipledb.service;

import uz.pdp.appmultipledb.dto.BookDTO;

import java.util.List;

public interface BookService {


    List<BookDTO> getAll();


    BookDTO getById(Integer id);

    BookDTO add(BookDTO bookDTO);

    BookDTO edit(Integer id, BookDTO bookDTO);

    void deleteById(Integer id);


    void deleteAll();



}
