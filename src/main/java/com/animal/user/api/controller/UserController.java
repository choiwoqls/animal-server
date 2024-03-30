package com.animal.user.api.controller;

import com.animal.user.api.dto.UserDTO;
import com.animal.user.api.model.User;
import com.animal.user.api.response.Response;
import com.animal.user.api.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/{id}")
    public Response<?> findUserSeq(@PathVariable("id")Long id ){

        return userService.findById(id);
    }



    @GetMapping(value = "/sign-in")
    public Response<?> signIn(@RequestBody UserDTO dto){

        return userService.login(dto.getEmail(),dto.getPassword());

    }



    @PostMapping(value = "/sign-up")
    public Response<?> signUp(@RequestBody UserDTO dto){

        return userService.save(dto);

    }





}
