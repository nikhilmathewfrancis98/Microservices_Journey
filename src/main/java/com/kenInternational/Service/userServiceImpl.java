package com.kenInternational.Service;

import com.kenInternational.Entity.User;
import com.kenInternational.Exception.UserNotFoundException;
import com.kenInternational.Repository.UserRepository;
import com.kenInternational.dto.UserDto;
import com.kenInternational.mapper.MapStruct;
import com.kenInternational.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * If we need to use the ModelMapper we can implement it inside this Class not in the UserMapper class
 * If we use the @AllArgs constructor annot we don't use the @Autowired coz if the class has 1 argument constructor the
 * Spring will automatically inject the bean
 *  For the time being we are using the ModelMapper only for the  getAllUsers() only
 *
 *  We are using the mapStruct inorder to map the object we are now implementing that to getUserByID()
 *  and also inside the createUser()
 */
@Service
@Slf4j
public class userServiceImpl extends Exception implements userService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public  ModelMapper mapper;
    @Override
    public UserDto updateUser(UserDto userdto) {
        User response=null;
      User existingUser=  userRepository.findById(userdto.getId()).get();
//       User s= User.builder().fName("DDDD").lName("FFF").email("fdd@gmail.com").build();
//        log.info(s.getEmail());
      if (!existingUser.equals(null)){
          existingUser.setFName(userdto.getFName());
          existingUser.setLName(userdto.getLName());
          existingUser.setEmail(userdto.getEmail());
          response= userRepository.save(existingUser);
      }else {
          throw new UserNotFoundException("No user by ID: " + userdto.getId());
//          return userRepository.findById(user.getId())
//                  .orElseThrow(() -> new UserNotFoundException("No user by ID: " + user.getId()));
      }

        //      or
//        User response=null;
//        User existingUser=  userRepository.findById(user.getId()).get();
//        if (!existingUser.equals(null)){
//            response=userRepository.save(user);
//        }
//        return response;

        return UserMapper.mapToUserDto(response);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers=userRepository.findAll();

        return allUsers.stream().map(user->mapper.map(user,UserDto.class)).collect(Collectors.toList());
//        return allUsers.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserByID(Long U_ID) {
        Optional<User> responseData=userRepository.findById(U_ID);
        System.out.println(responseData.get().getFName()+" "+responseData.get().getLName());
        UserDto response=MapStruct.Mapper.mapStructUserToDTO(responseData.get());
        System.out.println(response.getNote()+" "+response.getLName()+" "+response.getFName());
       return response;
//       return UserMapper.mapToUserDto(responseData.get()) ;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
//       User s= MapStruct.Mapper.mapStructDTOToUser(userDto); // This line of code returns null 
//        log.warn("Inside the Service Impl "+s.getLName()+" "+s.getFName());
        User user1=UserMapper.mapToUser(userDto);
        User response=userRepository.save(user1);
        UserDto savedUser= UserMapper.mapToUserDto(response);
        return savedUser;
    }

    @Override
    public boolean deleteUser(Long id) {
          userRepository.deleteById(id);
          return true;
    }

}
