package com.itstep.book.service.impl;

import com.itstep.book.model.Book;
import com.itstep.book.repository.BookRepository;
import com.itstep.book.service.BookService;
import com.itstep.book.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    @Override
    public BaseResponse createBook(Book book) {
        if (Objects.isNull(book)) {
            return new BaseResponse(400, "Impossible to add null", null);
        } else {
            repository.save(book);
            return new BaseResponse(200, "Book was created", book);
        }
    }

    @Override
    public BaseResponse deletebook(Integer bookId) {
        Book book = getBookById(bookId);
        if (Objects.isNull(book)) {
            return new BaseResponse(400, "Book not found", null);
        } else {
            repository.delete(book);
            return new BaseResponse(200, "Book successfully deleted", book);
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public Book getBookById(Integer bookId) {
        return repository.getById(bookId);
    }

    @Override
    public List<Book> findBooksByIds(List<Integer> ids) {
        return repository.findAllById(ids);
    }

}
