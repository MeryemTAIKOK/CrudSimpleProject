package ma.project.crud.serviceImpl;

import ma.project.crud.dao.BookJpaRepository;
import ma.project.crud.entities.Book;
import ma.project.crud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookJpaRepository bookJpaRepository;

    @Override
    public List<Book> listBook() {
        return bookJpaRepository.findAll();
    }

    @Override
    public Book getBookbyId(Long idBook) {
        Optional<Book> book=bookJpaRepository.findById(idBook);

        if(!book.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Can't find the book with the id("+idBook+")");
        }
        return bookJpaRepository.findById(idBook).get();}

    @Override
    public Book addBook(Book book) {
        return bookJpaRepository.save(book);
    }

    @Override
    public Book updateBook(Long idBook, Book book) {
        if(!idBook.equals(book.getIdBook())) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "The 'ID' in the URI is not the same as the book's to be apdated");
        }

        Optional<Book> book1=bookJpaRepository.findById(idBook);

        if(!book1.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Cannot find the book which the ID="+idBook+" ");
        }
        Book art=this.getBookbyId(idBook);
        art.setBookAuthorName(book.getBookAuthorName());
        art.setBookName(book.getBookName());

        return bookJpaRepository.save(art);    }

    @Override
    public boolean deleteBook(Long idBook) {

        if(bookJpaRepository.findById(idBook).isPresent()) {
            bookJpaRepository.deleteById(idBook);
            return true;
        }
        return false;
    }

    @Override
    public Page<Book> searchBook(String keyword, int page, int s) {
        return bookJpaRepository.lookForBook("%"+keyword+"%", (org.springframework.data.domain.Pageable) PageRequest.of(page, s));

    }
}
