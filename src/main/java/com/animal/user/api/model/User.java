package com.animal.user.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(length = 50, name = "name")
    private String name;

    @Column(length = 50, name = "email")
    private String email;

    // 비밀번호는 JSON 직렬화시 노출되지 않도록 하기 위해 @JsonIgnore 제거
    @Column(length = 50, name = "password")
    private String password;

    @Column(length = 50, name = "phone")
    private String phone;

    @Override
    public String toString() {
        return "User = [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", phone=" + phone + "]";
    }
}
