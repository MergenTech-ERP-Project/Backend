package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.User;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface UserService extends HelperService<User>{

    List<User> getUserList();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByName(String name);
    Optional<User> getUserByNameAndPassword(String name,String password);
   /* String createUser(User user);
    String updateUser(Long id, User user);
    String deleteUser(Long id);*/

}
