package com.mergen.vtys.vtysdatabaseap.Controller;




import com.mergen.vtys.vtysdatabaseap.Model.Activity;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.ActivityRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActivityService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("activity")
@RequiredArgsConstructor
@Slf4j
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping(value = "activities")
    public ResponseEntity<List<Activity>> getActivityList() {
        List<Activity> activityList =  activityService.getActivityList();
        log.info("All Activities Returned - {}",activityList);
        return ResponseEntity.ok(activityList);
    }

    @GetMapping(value = "activities/{id}")
    public ResponseEntity<Optional<Activity>> getActivityById(@PathVariable Long id) {
        Optional<Activity> status = activityService.getActivityById(id);
        log.info("Activity Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "post")
    public ResponseEntity<Activity> createActivity(@RequestBody Activity activity) {
        Activity status = activityService.Create(activity);
        log.info("Activity Added Status - {}",status);
        return ResponseEntity.status(HttpStatus.CREATED).body(activity);
    }

  /*  @PutMapping(value = "put/{id}")
    public ResponseEntity<String> updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
        String status = activityService.Update(id,activity);
        log.info("Activity Updated Status - {}",status);
        return ResponseEntity.ok("Activity updated!");
    }*/

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteActivity(@PathVariable() Long id) {
        String status = activityService.Delete(id);
        log.info("Activity Deleted Status - {}",status);
        return ResponseEntity.ok(id + "th Activity deleted!");
    }

}
