package com.ds.forlearnci.controllers;

import com.ds.forlearnci.models.dto.UserDto;
import com.ds.forlearnci.models.User;
import com.ds.forlearnci.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private UserService userService;
    private ObjectMapper mapper;

    @GetMapping()
    public List<UserDto> getUsers() {
        return userService.getUsers()
                .stream()
                .map(user -> mapper.convertValue(user, UserDto.class))
                .toList();
    }

    @PostMapping()
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = mapper.convertValue(userDto, User.class);
        return mapper.convertValue(userService.createUser(user), UserDto.class);
    }
}
