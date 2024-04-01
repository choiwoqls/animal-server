package com.animal.user.api.controller;

import com.animal.user.api.dto.UserDTO;

import com.animal.user.api.response.Response;
import com.animal.user.api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
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



    @GetMapping(value = "/sign-in")
    public Response<?> signIn(@RequestParam("email") String email, @RequestParam("password")String password){

        return userService.login(email,password);

    }



    @PostMapping(value = "/sign-up")
    public Response<?> signUp(@RequestBody UserDTO dto){

        return userService.save(dto);

    }





}
