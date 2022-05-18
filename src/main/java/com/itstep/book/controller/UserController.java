package com.itstep.book.controller;

import com.itstep.book.model.User;
import com.itstep.book.service.UserService;
import com.itstep.book.util.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/create")
    public BaseResponse createUser(@RequestBody User user, Model model) {
        return userService.createUser(user);
    }

    @GetMapping("/user/getall")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PutMapping("/user/update")
    public BaseResponse updatUser(@RequestBody User user, Model model) {
        return userService.createUser(user);
    }


    @DeleteMapping("/user/delete/{id}")
    public BaseResponse deleteUser(@PathVariable Integer id ) {
        return userService.deleteUser(id);
    }

    @PutMapping("/user/add/{id}/{idOfBook}")
    public BaseResponse addBookToUser (@PathVariable Integer id, @PathVariable Integer idOfBook, Model model) {
        return userService.takeBook(idOfBook, id);
    }

    @DeleteMapping("/user/delete/{id}/{idOfBook}")
    public BaseResponse deleteBookFromUser (@PathVariable Integer id, @PathVariable Integer idOfBook, Model model) {
        return userService.returnBook(idOfBook, id);
    }





}
