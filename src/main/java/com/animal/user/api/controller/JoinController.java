package com.animal.user.api.controller;


import com.animal.user.api.dto.UserDTO;
import com.animal.user.api.response.Response;
import com.animal.user.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class JoinController {

    private final UserService userService;

    @Autowired
    public JoinController(UserService userService){
        this.userService=userService;
    }


    @PostMapping(value = "/sign-up")
    public Response<?> signUp(@RequestBody UserDTO dto){

        return userService.save(dto);

    }
}
