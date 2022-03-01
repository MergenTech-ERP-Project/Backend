package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Model.Activity;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.UserRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActivityService;
import com.mergen.vtys.vtysdatabaseap.Service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final ActivityService activityService;

    @Autowired
    private final UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUserList(){
        return ResponseEntity.ok(userService.getUserLists());
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Optional<User>> getUsersCheckByName(@PathVariable("name") String name){
        return  ResponseEntity.ok(userService.getUserByName(name)) ;
    }

    @GetMapping(value ="/{name}/{password}")
    public ResponseEntity<Optional<User>> getUsersCheck(
            @PathVariable("name") String name,@PathVariable("password") String password) {
        return ResponseEntity.ok(userService.getUserNameAndPassword(name,password));
    }
    @GetMapping(value ="/check/{email}/{password}")
    public ResponseEntity<Optional<User>> getUsersCheckByMailandPass(
            @PathVariable("email") String email,@PathVariable("password") String password) {
        return ResponseEntity.ok(userService.getUserEmailAndPassword(email,password));
    }


    @PostMapping(value = "/post")
    public ResponseEntity<String> createUser(@RequestBody User user){
        userService.Create(user);
        return ResponseEntity.ok(user.getName() + " created!");
    }

    @PutMapping(value = "put/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {
        userService.Update(id, user);
        return ResponseEntity.ok(user.getName() + " updated!");

    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable() Long id){
        userService.Delete(id);
        return ResponseEntity.ok(id + " th deleted!");
    }

    }
