package com.itstep.book.service;

import com.itstep.book.model.Book;
import com.itstep.book.model.User;
import com.itstep.book.util.BaseResponse;

import java.util.List;

public interface UserService {
    BaseResponse createUser(User user);
    BaseResponse updateUser(User user);
    BaseResponse deleteUser(Integer id);
    BaseResponse takeBook(Integer idOfBook, Integer id);
    BaseResponse returnBook(Integer idOfBook, Integer id);
    List<User> getAllUsers();
    User getUserById(Integer userId);







}
