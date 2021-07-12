package com.example.library.controller;


import com.example.library.domain.User;
import com.example.library.dto.UserDto;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userService.save(user, true);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        userService.update(id, userDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }

    @GetMapping("/getwhohavebook")
    public List<UserDto> getAllUserWhoHaveBook() {
        return userService.getAllUserWhoHaveBook();
    }


}
