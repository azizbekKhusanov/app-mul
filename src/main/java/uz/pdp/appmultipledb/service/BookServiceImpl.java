package uz.pdp.appmultipledb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.appmultipledb.document.second.Book;
import uz.pdp.appmultipledb.dto.BookDTO;
import uz.pdp.appmultipledb.exceptions.AppException;
import uz.pdp.appmultipledb.repository.second.BookRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;


    @Override
    public List<BookDTO> getAll() {
        List<Book> all = bookRepository.findAll();
        if (all.isEmpty())
            throw new AppException("This list is empty");

        return all.stream()
                .map(this::mapToBookDTOFomBook)
                .toList();
    }

    @Override
    public BookDTO getById(Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new AppException("Book not found"));
        return mapToBookDTOFomBook(book);
    }
    @Override
    public BookDTO add(BookDTO bookDTO) {
        Book book = mapToBookFomBookDTO(bookDTO);

        return mapToBookDTOFomBook(bookRepository.save(book));
    }

    @Override
    public BookDTO edit(Integer id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new AppException("Book not found"));

        book.setName(bookDTO.getName());
        book.setPage(bookDTO.getPage());

        return mapToBookDTOFomBook(bookRepository.save(book));
    }

    @Override
    public void deleteById(Integer id) {
        bookRepository.findById(id)
                .orElseThrow(() -> new AppException("Book not found"));

        bookRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        if(bookRepository.findAll().isEmpty())
            throw new AppException("This list is empty");

        bookRepository.deleteAll();
    }


    private BookDTO mapToBookDTOFomBook(Book book) {

        return BookDTO.builder()
                .name(book.getName())
                .page(book.getPage())
                .build();
    }

    private Book mapToBookFomBookDTO(BookDTO bookDTO) {

        return Book.builder()
                .name(bookDTO.getName())
                .page(bookDTO.getPage())
                .build();
    }
}
