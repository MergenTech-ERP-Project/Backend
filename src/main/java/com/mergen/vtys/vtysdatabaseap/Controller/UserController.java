package com.mergen.vtys.vtysdatabaseap.Controller;



import com.mergen.vtys.vtysdatabaseap.Dto.UserDto;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.UserRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActivityService;
import com.mergen.vtys.vtysdatabaseap.Service.UserDetailsService;
import com.mergen.vtys.vtysdatabaseap.Service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "user")
@Slf4j
public class UserController {
    private final ActivityService activityService;

    private final UserRepository userRepository;

    private final UserService userService;

    private  final UserDetailsService userDetailsService;


    public UserController(UserService userService, ActivityService activityService, UserRepository userRepository, UserDetailsService userDetailsService) {
        this.userService = userService;
        this.activityService = activityService;
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<UserDto>> getUserList(){
        List<UserDto> userList = userService.getUserLists();
        log.info("All Users Returned - {}", userList);
        return ResponseEntity.ok(userList);
    }

    @GetMapping(value = "/list/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id){
        UserDto status = userService.getUserById(id);
        log.info("User Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<UserDto> getUsersCheck(@PathVariable("name") String name){
        UserDto status = userService.getUserByName(name);
        log.info("User Got by Name Status - {}",status);
        return  ResponseEntity.ok(status) ;
    }

    @GetMapping(value ="/check/name:{name}&pass:{password}")
    public ResponseEntity<UserDto> getUsersCheck(
            @PathVariable("name") String name,@PathVariable("password") String password) {
        UserDto status = userService.getUserNameAndPassword(name,password);
        log.info("User Got by Name And Password Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value ="/check/email:{email}&pass:{password}")
    public ResponseEntity<UserDto> getUsersCheckByMailandPass(
            @PathVariable("email") String email,@PathVariable("password") String password) {
        UserDto status = userService.getUserEmailAndPassword(email,password);
        log.info("User Got by E-mail And Password Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto status = userService.Create(userDto);
        log.info("User Added Status - {}",status);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        String status = userService.Update(id, userDto);
        log.info("User Updated Status - {}",status);
        return ResponseEntity.ok(userDto.getName() + " updated!");
    }

    @DeleteMapping(value = "/remove/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable() Long id){
        String status = userService.Delete(id);
        log.info("User Deleted Status - {}",status);
        return ResponseEntity.ok(id + " th deleted!");
    }
    }
