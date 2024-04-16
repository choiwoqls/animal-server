package com.animal.user.api.service;

import com.animal.user.api.dto.CustomUserDetails;
import com.animal.user.api.model.User;
import com.animal.user.api.repository.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if(user != null){
            System.out.println("customUserDetailsService :: username = " + user.getUsername()+ ", password = " +user.getPassword() + ", name = " + user.getName()+ ", phone = " + user.getPhone() + ", role : " +user.getRole());
            return new CustomUserDetails(user);
        }

        return null;
    }
}
