package com.mergen.vtys.vtysdatabaseap.Controller;



import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.UserRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActivityService;
import com.mergen.vtys.vtysdatabaseap.Service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.List;
import java.util.Optional;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final ActivityService activityService;

    @Autowired
    private final UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUserList(){
        List<User> userList = userService.getUserLists();
        log.info("All Users Returned - {}", userList);
        return ResponseEntity.ok(userList);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        Optional<User> status = userService.getUserById(id);
        log.info("User Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Optional<User>> getUsersCheck(@PathVariable("name") String name){
        Optional<User> status = userService.getUserByName(name);
        log.info("User Got by Name Status - {}",status);
        return  ResponseEntity.ok(status) ;
    }

    @GetMapping(value ="/{name}/{password}")
    public ResponseEntity<Optional<User>> getUsersCheck(
            @PathVariable("name") String name,@PathVariable("password") String password) {
        Optional<User> status = userService.getUserNameAndPassword(name,password);
        log.info("User Got by Name And Password Status - {}",status);
        return ResponseEntity.ok(status);
    }
    @GetMapping(value ="/check/{email}/{password}")
    public ResponseEntity<Optional<User>> getUsersCheckByMailandPass(
            @PathVariable("email") String email,@PathVariable("password") String password) {
        Optional<User> status = userService.getUserEmailAndPassword(email,password);
        log.info("User Got by E-mail And Password Status - {}",status);
        return ResponseEntity.ok(status);
    }


    @PostMapping(value = "/post")
    public ResponseEntity<String> createUser(@RequestBody User user){
        User status = userService.Create(user);
        log.info("User Added Status - {}",status);
        return ResponseEntity.ok(user.getName() +" created");
        //return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping(value = "/put/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user) {

        String status = userService.Update(id, user);
        log.info("User Updated Status - {}",status);
        return ResponseEntity.ok(user.getName() + " updated!");

    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable() Long id){
        String status = userService.Delete(id);
        log.info("User Deleted Status - {}",status);
        return ResponseEntity.ok(id + " th deleted!");
    }
    }
