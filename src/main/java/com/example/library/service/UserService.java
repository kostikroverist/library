package com.example.library.service;

import com.example.library.domain.User;
import com.example.library.dto.UserDto;

import java.util.List;

public interface UserService {


    void save(User user, boolean isCreateUser);

    void update(long id, UserDto userDto);

    void deleteById(long id);

    List<UserDto> getAllUserWhoHaveBook();

    User getByNameOrCreate(String firstName, String lastName);
}
