package com.unemployed.ltnam.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unemployed.ltnam.Entity.Book;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
    @SuppressWarnings("null")
    List<Book> findAll();
    List<Book> findById(int id);
    // save(Book book);
}
