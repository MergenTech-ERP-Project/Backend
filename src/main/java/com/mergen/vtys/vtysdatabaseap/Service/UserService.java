package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.UserDto;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService extends HelperService<UserDto>{
    // @Query(value = "SELECT * from user",nativeQuery = true)
    @Query("Select u From User u ")
    List<UserDto> getUserLists();
    UserDto getUserById(Long id);
    UserDto getUserByName(String name);
    UserDto getUserEmailAndPassword(String email,String password);

    // @Query(value = "SELECT * from User Where name=? and password=?", nativeQuery = true)
    UserDto getUserNameAndPassword(String name, String password);
   /* String createUser(User user);
    String updateUser(Long id, User user);
    String deleteUser(Long id);*/


}
