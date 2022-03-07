package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.dto.UserDto;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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
