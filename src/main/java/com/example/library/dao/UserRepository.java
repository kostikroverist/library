package com.example.library.dao;

import com.example.library.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);

    List<User> findUserByBooksNotNull();


}
