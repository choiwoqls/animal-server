package com.animal.user.api.repository;

import com.animal.user.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findById(long id);

    User findByUsername(String username);

    Optional<User> findByPhone(String phone);



}
