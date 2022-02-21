package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.User;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UserService extends HelperService<User>{
  // @Query(value = "SELECT * from user",nativeQuery = true)
    @Query("Select u From User u ")
    List<User> getUserLists();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByName(String name);

   // @Query(value = "SELECT * from User Where name=? and password=?", nativeQuery = true)
    Optional<User> getUserNameAndPassword(String name, String password);
   /* String createUser(User user);
    String updateUser(Long id, User user);
    String deleteUser(Long id);*/


}
