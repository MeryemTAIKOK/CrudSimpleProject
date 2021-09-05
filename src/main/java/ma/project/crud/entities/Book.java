package ma.project.crud.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long idBook;
    private String bookName;
    private String bookAuthorName;

    public Book() {
    }

    public Book(String bookName, String bookAuthorName) {
        this.bookName = bookName;
        this.bookAuthorName = bookAuthorName;
    }


    public Long getIdBook() {
        return idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", bookName='" + bookName + '\'' +
                ", bookAuthorName='" + bookAuthorName + '\'' +
                '}';
    }
}
