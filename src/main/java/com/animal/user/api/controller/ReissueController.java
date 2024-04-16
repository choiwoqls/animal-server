package com.animal.user.api.controller;

import com.animal.user.api.model.Refresh;
import com.animal.user.api.repository.RefreshRepository;
import com.animal.user.api.response.Response;
import com.animal.user.api.service.ReissueService;
import com.animal.user.security.jwt.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@ResponseBody
public class ReissueController {

    private final ReissueService reissueService;

    @Autowired
    public ReissueController(ReissueService reissueService){
        this.reissueService=reissueService;
    }

    @PostMapping("/reissue")
    public ResponseEntity<?> reissue(HttpServletRequest request, HttpServletResponse response){
        //get refresh token
        return reissueService.reIssue(request,response);

    }




}
