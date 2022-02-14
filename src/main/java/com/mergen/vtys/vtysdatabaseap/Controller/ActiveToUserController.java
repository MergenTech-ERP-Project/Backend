package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import com.mergen.vtys.vtysdatabaseap.Service.ActiveToUserService;
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
@RequestMapping("activetouser")
@RequiredArgsConstructor
public class ActiveToUserController {

    @Autowired
    private ActiveToUserService activeToUserService;

    @GetMapping(value = "activetousers")
    public ResponseEntity<List<ActiveToUser>> getActivityList() {
        return ResponseEntity.ok((List<ActiveToUser>) activeToUserService.getActivityList());
    }

    @GetMapping(value = "activetouser/{id}")
    public ResponseEntity<Optional<ActiveToUser>> getActivityById(@PathVariable Long id) {
        return ResponseEntity.ok(activeToUserService.getActivityById(id));
    }

    @PostMapping(value = "post")
    public ResponseEntity<String> createActivity(@RequestBody ActiveToUser activetouser) {
        activeToUserService.Create(activetouser);
        return ResponseEntity.ok("ActiveToUser Saved Succesfully");
    }

    @PutMapping(value = "put/{id}")
    public ResponseEntity<String> updateActiveToUser(@PathVariable Long id, @RequestBody ActiveToUser activetouser) {
        activeToUserService.Update(id,activetouser);
        return ResponseEntity.ok("ActivityUser updated!");
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteActivityToUser(@PathVariable() Long id) {
          activeToUserService.Delete(id);
        return ResponseEntity.ok(id + "ActivityToUser deleted!");
    }

}

    