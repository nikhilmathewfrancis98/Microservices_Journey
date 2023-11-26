package com.kenInternational.controller;

import com.kenInternational.Entity.User;

import com.kenInternational.Exception.UserNotFoundException;
import com.kenInternational.Service.userService;
import com.kenInternational.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private userService userService;
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        log.warn(user.getFName());
       UserDto savedUser= userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDto> getTheData(@PathVariable("id") Long U_ID){
       UserDto user= userService.getUserByID(U_ID);
        return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long U_Id,@RequestBody UserDto userDto){
        log.warn(userDto.getEmail()+" "+U_Id);
        userDto.setId(U_Id);
       return new ResponseEntity<>(userService.updateUser(userDto),HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long U_Id){
        if (userService.deleteUser(U_Id)){
            return new ResponseEntity<>("User Successfully deleted!",HttpStatus.OK);
        }else {
            return  new ResponseEntity<>("User not deleted !",HttpStatus.NOT_MODIFIED);
        }

    }
}
