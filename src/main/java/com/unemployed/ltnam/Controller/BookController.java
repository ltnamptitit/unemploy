package com.unemployed.ltnam.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unemployed.ltnam.DTO.BookDTO.BookDTO;
import com.unemployed.ltnam.DTO.Response.Response;
import com.unemployed.ltnam.Services.Book.BookServices;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookServices bookServices;

    public BookController(BookServices bookServices) {
        this.bookServices = bookServices;
    }

    @GetMapping("/all")
    public ResponseEntity<Response> getAllBook() {
        return bookServices.getBook();
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/new")
    public ResponseEntity<Response> addNewBook(@RequestBody BookDTO entity) {
        return bookServices.addNewBook(entity);
    }

    @SuppressWarnings("unchecked")
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable int id, @RequestBody BookDTO entity) {
        return bookServices.updateBook(id, entity);
    }

    @PutMapping("delete/{id}")
    public ResponseEntity deleteBook(@PathVariable int id) {
        return bookServices.deleteBook(id);
    }
}
