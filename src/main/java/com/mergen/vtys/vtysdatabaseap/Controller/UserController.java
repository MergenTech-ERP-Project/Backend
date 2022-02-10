package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Classes.User;
import com.mergen.vtys.vtysdatabaseap.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("users")
    public List<User> getUserList(){
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("users/{id}")
    public Optional<User> getUserById(@PathVariable Long id){
        return userRepository.findById(id);
    }

    @GetMapping("/users/{name}/{password}")
    @ResponseBody
    public Optional<User> getUsersCheck(
            @PathVariable("name") String name,@PathVariable("password") String password) {
        return  userRepository.findByNameAndPassword(name,password) ;
    }

    @PostMapping("post")
    public String createUser(@RequestBody User user){
        userRepository.save(user);
        return user.getName() + " Saved Successfully";
    }

    @PutMapping("put/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user){
        userRepository.save(user);
        return user.getName() + " updated!";
    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable() Long id){
        userRepository.deleteById(id);
        return id + "th User deleted!";
    }
}
