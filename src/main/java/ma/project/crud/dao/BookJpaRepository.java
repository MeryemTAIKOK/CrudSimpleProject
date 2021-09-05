package ma.project.crud.dao;

import ma.project.crud.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface BookJpaRepository extends JpaRepository<Book,Long> {
    @Query("from Book a where a.bookName like :x")
    public Page<Book> lookForBook(@Param("x")String mc, Pageable pageable);


}
