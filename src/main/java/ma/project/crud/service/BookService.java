package ma.project.crud.service;

import ma.project.crud.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

public List<Book> listBook();
public  Book getBookbyId(Long idBook);
public Book addBook(Book book);
public Book updateBook(Long idBook,Book book);
public boolean deleteBook(Long idBook);
public Page<Book> searchBook(String keyword, int page, int s);
}
