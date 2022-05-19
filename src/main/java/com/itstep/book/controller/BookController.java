package com.itstep.book.controller;

import com.itstep.book.model.Book;
import com.itstep.book.service.BookService;
import com.itstep.book.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/book/create")
    public BaseResponse createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/book/getall")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


    @PutMapping("/book/update")
    public BaseResponse updateBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }


    @DeleteMapping("/book/delete/{id}")
    public BaseResponse deleteBook(@PathVariable Integer id ) {
        return bookService.deletebook(id);
    }


}
