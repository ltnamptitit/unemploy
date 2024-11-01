package com.unemployed.ltnam.Services.Book;

import org.springframework.http.ResponseEntity;

import com.unemployed.ltnam.DTO.BookDTO.BookDTO;
import com.unemployed.ltnam.DTO.Response.Response;

public interface BookServices {
    ResponseEntity getBook();

    @SuppressWarnings("rawtypes")
    ResponseEntity addNewBook(BookDTO bookDTO);

    @SuppressWarnings("rawtypes")
    ResponseEntity updateBook(int id, BookDTO bookDTO);

    ResponseEntity deleteBook(int id);
}