package com.animal.user.api.repository;

import com.animal.user.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    public Optional<User> findByEmailAndPassword(String email, String password);

    public Optional<User> findById(long id);

    public Optional<User> findByEmail(String email);

    public Optional<User> findByPhone(String phone);



}
