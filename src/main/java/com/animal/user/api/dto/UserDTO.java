package com.animal.user.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private long id;
    private String name;
    private String username;
    private String password;
    private String phone;
    private String role;
}
