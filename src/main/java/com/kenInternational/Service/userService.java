package com.kenInternational.Service;

import com.kenInternational.Entity.User;
import com.kenInternational.dto.UserDto;

import java.util.List;

public interface userService {

    UserDto updateUser(UserDto user);
    List<UserDto>getAllUsers();
   UserDto getUserByID(Long U_ID);
    UserDto createUser(UserDto user);

    boolean deleteUser(Long id);
}
