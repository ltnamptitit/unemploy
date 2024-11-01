package com.unemployed.ltnam.Services.Book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.unemployed.ltnam.DTO.BookDTO.BookDTO;
import com.unemployed.ltnam.DTO.Response.Response;
import com.unemployed.ltnam.Entity.Book;
import com.unemployed.ltnam.Mapper.BookMapper;
import com.unemployed.ltnam.Repository.BookRepository;

@Service
public class BookServicesImpl implements BookServices {
    private BookRepository bookRepository;

    public BookServicesImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Autowired
    private BookMapper bookMapper;

    @Override
    public ResponseEntity getBook() {
        List<Book> listBook = bookRepository.findAll();
        // Response res = Response.builder()
        return ResponseEntity.status(HttpStatus.OK)
                .body(Response.builder()
                        .data(listBook)
                        .build());
    }

    @Override
    public ResponseEntity addNewBook(BookDTO bookDTO) {
        try {
            Book book = bookMapper.toBook(bookDTO);
            bookRepository.save(book);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(Response.builder()
                            .message("book created")
                            .build());

        } catch (NullPointerException | IllegalArgumentException e) {
            // TODO: handle exception
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(Response.builder()
                            .message(e.getMessage())
                            .build());
        }

    }

    @Override
    public ResponseEntity updateBook(int id, BookDTO bookDTO) {
        try {
            List<Book> listExistBook = bookRepository.findById(id);
            if (listExistBook.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Book existBook = bookMapper.toUpdateBook(bookDTO, listExistBook.get(0));
            bookRepository.save(existBook);
            // Book book = bookMapper.toBook(bookDTO);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(Response.builder()
                            .data(existBook)
                            .build());
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Response.builder().message(e.getMessage()).build());
        }
    }

    @Override
    public ResponseEntity deleteBook(int id) {
        try {
            List<Book> books;
            books = bookRepository.findById(id);
            if(books == null || books.isEmpty()){
                return ResponseEntity.notFound().build();
            }
            Book selectedBook = books.get(0);
            selectedBook.setIs_available(0);
            bookRepository.save(selectedBook);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Response.builder().message(e.getMessage()).build());
        }
    }
}
