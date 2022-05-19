package com.itstep.book.service.impl;

import com.itstep.book.model.Book;
import com.itstep.book.model.User;
import com.itstep.book.repository.UserRepository;
import com.itstep.book.service.BookService;
import com.itstep.book.service.UserService;
import com.itstep.book.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BookService service;

    @Override
    public BaseResponse createUser(User user) {
        if (Objects.isNull(user)) {
            return new BaseResponse(400, "Impossible to add null-user", null);
        } else if (user.getBooks() == null) {
            repository.save(user);
            return new BaseResponse(200, "User was created", user);
        } else {
            return new BaseResponse(400, "You could`n create user with books", null);
        }
    }

    @Override
    public BaseResponse updateUser(User user) {
        User user1 = repository.findById(user.getId()).orElse(null);
        if (Objects.nonNull(user1)) {
            user1.setName(user.getName());
            user1.setBooks(service.findBooksByIds(user.getBooks().stream().map(Book::getId).collect(Collectors.toList())));
            repository.save(user1);
        }
        return new BaseResponse(200, "User was updated", user1);

    }

    @Override
    public BaseResponse deleteUser(Integer id) {
        User user = getUserById(id);
        if (Objects.isNull(user)) {
            return new BaseResponse(400, "User not found", null);
        } else {
            repository.delete(user);
            return new BaseResponse(200, "Book successfully deleted", user);
        }
    }

    @Override
    public BaseResponse takeBook(Integer idOfBook, Integer id) {
        User user1 = repository.findById(id).orElse(null);
        Book book = service.getBookById(idOfBook);
        if (Objects.isNull(user1)) {
            return new BaseResponse(400, "User was not find", null);
        } else {
            if (user1.getBooks().contains(book)) {
                return new BaseResponse(400, "Book is already with this user", null);
            } else if (!book.isAtUser()) {
                user1.getBooks().add(book);
                book.setAtUser(true);
                repository.save(user1);
                return new BaseResponse(200, "Book is successfully added", user1);
            } else {
                return new BaseResponse(400, "Book is at another user", null);
            }
        }
    }

    @Override
    public BaseResponse returnBook(Integer idOfBook, Integer id) {
        User user1 = repository.findById(id).orElse(null);
        Book book = service.getBookById(idOfBook);
        if (Objects.isNull(user1)) {
            return new BaseResponse(400, "User was not find", null);
        } else {
            if (user1.getBooks().contains(book)) {
                user1.getBooks().remove(book);
                repository.save(user1);
                book.setAtUser(false);
                service.createBook(book);
                return new BaseResponse(200, "Book is successfully added", user1);

            } else {
                return new BaseResponse(400, "Book is not at user", null);
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User getUserById(Integer userId) {
        return repository.getById(userId);
    }
}
