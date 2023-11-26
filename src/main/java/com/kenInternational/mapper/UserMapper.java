package com.kenInternational.mapper;

import com.kenInternational.Entity.User;
import com.kenInternational.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;




public class UserMapper {

//    @Autowired
//    public  ModelMapper mapper;

    public static UserDto mapToUserDto(User user){
//        UserDto savedUser=mapper.map(user,UserDto.class);
         UserDto savedUser=new UserDto(user.getId(), user.getFName(), user.getLName(), user.getEmail());
         return savedUser;
    }

    public static User mapToUser(UserDto userDto){
//        User user1 = mapper.map(userDto,User.class); // This is code that convert the userDto to user using the Model mapper
        User user1=User.builder().lName(userDto.getLName()).fName(userDto.getFName()).
                id(userDto.getId()).email(userDto.getEmail()).build();
        return user1;
    }

//    public  UserDto mapToUserDtoModelMapper(User user){
//        UserDto savedUser=mapper.map(user,UserDto.class);
//        return savedUser;
//    }
//
//    public  User mapToUserModelMapper(UserDto userDto){
//        User user1 = mapper.map(userDto,User.class); // This is code that convert the userDto to user using the Model mapper
//        return user1;
//    }
}
