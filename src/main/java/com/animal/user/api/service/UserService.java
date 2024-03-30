package com.animal.user.api.service;

import com.animal.user.api.dto.UserDTO;
import com.animal.user.api.repository.UserRepository;
import com.animal.user.api.model.User;
import com.animal.user.api.response.Response;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //private final BCryptPasswordEncoder bCryptPasswordEncoder;


    //로그인 (DB 비교 만)
    public Response<?> login(String email, String password){

        String msg = "";
        String suc = "";
        Optional<User> user = Optional.of(new User());

        if(userRepository.findByEmail(email).isEmpty()){
            msg = "등록되지 않은 아이디 입니다";
            suc = "failed";
            user = Optional.empty();
            return new Response<>(suc,msg,user);
        }

        if(userRepository.findByEmailAndPassword(email, password).isEmpty()){
            msg = "비밀번호를 확인하세요";
            suc = "failed";
            user = Optional.empty();
            return new Response<>(suc,msg,user);
        }


        user = userRepository.findByEmailAndPassword(email, password);
        msg = "로그인 성공";
        suc = "success";


        return new Response<>(suc,msg,user);
    }

    //user_seq 회원 정보 추출
    public Response<?> findById(long id){

        String msg = "";
        String suc = "";
        Optional<User> user = Optional.of(new User());

        if(userRepository.findById(id).isPresent()){
            msg = "회원 정보 추출";
            suc = "성공";
            user = userRepository.findById(id);
        }else{
            msg = "등록된 회원 정보 없음";
            suc = "실패";
            user = Optional.empty();
        }

        Response<?> response = new Response(suc, msg,user);


        return response;
    }



    public Response<?> save (UserDTO dto){

        if(this.checkEmpty(dto).getSuccess().equals("failed")){
            return checkEmpty(dto);
        }

        if(this.checkRegularExpression(dto).getSuccess().equals("failed")){
            return checkRegularExpression(dto);
        }

        if(this.checkDuplication(dto).getSuccess().equals("failed")){
            return checkDuplication(dto);
        }

        //dto.setUserPassword(bCryptPasswordEncoder.encode(dto.getUserPassword()));



        return new Response<>("success", "회원가입성공",userRepository.save(this.makeEntity(dto)));

    }

    public User makeEntity(UserDTO dto){
        User user = new User();

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhone(dto.getPhone());

        return user;
    }

    public Response<?> checkEmpty(UserDTO dto){
        String suc = "";
        String msg = "";

        System.out.println("empty");


        if(dto.getName().isEmpty()){
            suc = "failed";
            msg = "이름을 입력하시오";
        }else if(dto.getEmail().isEmpty()){
            suc = "failed";
            msg = "아이디을 입력하시오";
        }else if(dto.getPassword().isEmpty()){
            suc = "failed";
            msg = "비밀번호를 입력하시오";
        }else if (dto.getPhone().isEmpty()){
            suc = "failed";
            msg = "전화번호를 입력하시오";
        }
        return new Response<>(suc,msg,null);
    }

    public Response<?> checkDuplication(UserDTO dto){

        System.out.println("checkDuplication");

        String suc = "";
        String msg = "";

        if(userRepository.findByEmail(dto.getEmail()).isPresent()){
            msg = "중복된 아이디";
            suc = "failed";
        }else if(userRepository.findByPhone(dto.getPhone()).isPresent()){
            msg = "중복된 전화번호";
            suc = "failed";
        }

        return new Response<>(suc,msg,null);
    }

    public Response<?> checkRegularExpression(UserDTO dto){

        System.out.println("checkRegularExpression");

        String suc = "";
        String msg = "";

        String password_regex = "^(?=.*\\d.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,16}$";

        String phone_regex = "^01[016-9]\\d{3,4}\\d{4}$";

        Pattern pattern = Pattern.compile(password_regex);
        // Matcher 생성
        Matcher matcher = pattern.matcher(dto.getPassword());

        if(!matcher.matches()){
            suc = "failed";
            msg = "비밀번호를 숫자(최소 2개)+영어+특수문자(최소 1개) 총 8~16자리로 입력하시오";
        }

        pattern = Pattern.compile(phone_regex);
        matcher = pattern.matcher(dto.getPhone());

        if(!matcher.matches()){
            suc = "failed";
            msg = "전화번호 형식으로 입력하시오";
        }

        return new Response<>(suc,msg,null);

    }






}
