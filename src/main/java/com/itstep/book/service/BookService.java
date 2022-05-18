package com.itstep.book.service;

import com.itstep.book.model.Book;
import com.itstep.book.util.BaseResponse;

import java.util.List;

public interface BookService {

    BaseResponse createBook(Book book);
    BaseResponse deletebook(Integer bookId);
    List<Book> getAllBooks();
    Book getBookById(Integer bookId);
    List<Book> findBooksByIds(List<Integer> ids);

}
