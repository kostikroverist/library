package com.example.library.service.impl;

import com.example.library.domain.Book;
import com.example.library.domain.User;
import com.example.library.dto.UserDto;
import com.example.library.exception.NotFoundException;
import com.example.library.dao.UserRepository;
import com.example.library.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user, boolean isCreateUser) {
        System.out.println(user);


        if (!isCreateUser) {
            List<Book> bookList = user.getBooks();

            for (Book book : bookList) {
                book.setUser(user);

            }

        }
        userRepository.save(user);
    }

    @Override
    public void update(long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found with this  id :" + id));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());

        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {

        User foundIdForDelete = userRepository.findById(id).orElseThrow((() -> new NotFoundException("Book not found with this  id :" + id)));
        Long idForDelete = foundIdForDelete.getId();
        userRepository.deleteById(idForDelete);
    }

    @Override
    public List<UserDto> getAllUserWhoHaveBook() {
        Iterable<User> userIterable = userRepository.findUserByBooksNotNull();

        return StreamSupport.stream(userIterable.spliterator(), false).map(user -> {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            return userDto;
        }).collect(Collectors.toList());
    }

    @Override
    public User getByNameOrCreate(String firstName, String lastName) {
        User user;
        Optional<User> optionalUser = userRepository.findByFirstNameAndLastName(firstName, lastName);

        if (optionalUser.isEmpty()) {
            user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user = userRepository.save(user);
        } else {
            user = optionalUser.get();
        }

        return user;
    }


}
