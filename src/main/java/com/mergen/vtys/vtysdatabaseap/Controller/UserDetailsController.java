package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Dto.UserDetailsDto;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserDetailsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "userdetail")
@Slf4j
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping(value = "/list")
    public ResponseEntity<List<UserDetailsDto>> getUserList(){
        List<UserDetailsDto> userList = userDetailsService.getUserDetailsList();
        log.info("All Users Returned - {}", userList);
        return ResponseEntity.ok(userList);
    }


    @GetMapping(value = "/list/{id}")
    public ResponseEntity<UserDetailsDto> getUserById(@PathVariable Long id){
        UserDetailsDto status = userDetailsService.getUserDetailsById(id);
        log.info("User Details Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value = "/find/tc:{tc_no}")
    public ResponseEntity<UserDetailsDto> findByTcNo(@PathVariable() String tc_no) {
        UserDetailsDto status = userDetailsService.findTcNo(tc_no);
        log.info("User Details Got by Tc_No Status - {}", status);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value = "/find/userid:{user_id}")
    public ResponseEntity<UserDetailsDto> findbyUserId(@PathVariable() Long user_id) {
        UserDetailsDto status = userDetailsService.FindByUserid(user_id);
        log.info("User Details Got by User_id Status - {}", status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<UserDetailsDto> createUser(@RequestBody UserDetailsDto userDetailsDto){
        UserDetailsDto status = userDetailsService.Create(userDetailsDto);
        log.info("User Details Added Status - {}",status);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDetailsDto);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDetailsDto userDetailsDto) {
        String status = userDetailsService.Update(id, userDetailsDto);
        log.info("User Details Updated Status - {}",status);
        return ResponseEntity.ok("TC No:" + userDetailsDto.getTc_no() + " updated!");
    }

    @DeleteMapping(value = "remove/{id}")
    public ResponseEntity<String> deleteUserDetails(@PathVariable() Long id){
        String status = userDetailsService.Delete(id);
        log.info("User Details Deleted Status - {}",status);
        return ResponseEntity.ok(id + " th deleted!");
    }

}