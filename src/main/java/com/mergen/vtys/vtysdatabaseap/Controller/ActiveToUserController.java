package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Classes.ActiveToUser;
import com.mergen.vtys.vtysdatabaseap.Repository.ActivityToUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("activetouser")
public class ActiveToUserController {
  @Autowired
  private ActivityToUserRepository activityToUserRepository;
  @GetMapping("activetousers")
  public List<ActiveToUser> getActivityList() {
    return (List<ActiveToUser>) activityToUserRepository.findAll();
}

@GetMapping("activetouser/{id}")
public Optional<ActiveToUser> getActivityById(@PathVariable Long id) {
    return activityToUserRepository.findById(id);
}

@PostMapping("post")
public String createActivity(@RequestBody ActiveToUser activetouser) {
    activityToUserRepository.save(activetouser);
    return   "ActiveToUser Saved Succesfully";
}

@PutMapping("put/{id}")
public String updateActiveToUser(@PathVariable Long id, @RequestBody ActiveToUser activetouser) {
    activityToUserRepository.save(activetouser);
    return "ActivityUser updated!";
}

@DeleteMapping("delete/{id}")
public String deleteActivityToUser(@PathVariable() Long id) {
      activityToUserRepository.deleteById(id);
    return id + "ActivityToUser deleted!";
}

}

    