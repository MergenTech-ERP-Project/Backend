package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserDetailsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "userdetail")
@RequiredArgsConstructor
public class UserDetailsController {

@Autowired
private final UserDetailsRepository userDetailsRepository;
@Autowired
private final UserDetailsService userDetailsService;

    @GetMapping(value = "/userdetails")
    public ResponseEntity<List<UserDetails>> getUserDetailsList(){
        return ResponseEntity.ok(userDetailsService.getUserDetailsList());
    }


    @GetMapping(value = "userdetails/{id}")
    public ResponseEntity<Optional<UserDetails>> getUserDetailsById(@PathVariable Long id){
        return  ResponseEntity.ok(userDetailsService.getUserDetailsById(id));
    }

    @PostMapping(value = "/post")
    public ResponseEntity<String> createUserDetails(@RequestBody UserDetails userDetails){
        userDetailsService.Create(userDetails);
        return ResponseEntity.ok(userDetails.getAddress()+ " created!");
    }

    @PutMapping(value = "put/{id}")
    public ResponseEntity<String> updateUserDetails(@PathVariable Long id, @RequestBody UserDetails userDetails) {
        userDetailsService.Update(id, userDetails);
        return ResponseEntity.ok(userDetails.getAddress() + " updated!");
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteUserDetails(@PathVariable() Long id){
        userDetailsService.Delete(id);
        return ResponseEntity.ok(id + " th deleted!");
    }

}