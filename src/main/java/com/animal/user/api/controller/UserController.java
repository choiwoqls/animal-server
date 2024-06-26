package com.animal.user.api.controller;



import com.animal.user.api.response.Response;
import com.animal.user.api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public Response<?> findUserSeq(@PathVariable("id")Long id ){

        return userService.findById(id);
    }



//    @PostMapping(value = "/sign-in")
//    public Response<?> signIn(@RequestBody UserDTO dto){
//        System.out.println("로그인 로그인 asdasdasd");
//        return userService.login(dto.getEmail(),dto.getPassword());
//
//    }









}
