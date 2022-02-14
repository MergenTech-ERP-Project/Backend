package com.mergen.vtys.vtysdatabaseap.Controller;




import com.mergen.vtys.vtysdatabaseap.Model.Activity;
import com.mergen.vtys.vtysdatabaseap.Repository.ActivityRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActivityService;
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
@RequestMapping("activity")
@RequiredArgsConstructor
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping(value = "activities")
    public ResponseEntity<List<Activity>> getActivityList() {
        return ResponseEntity.ok((List<Activity>) activityService.getActivityList());
    }

    @GetMapping(value = "activities/{id}")
    public ResponseEntity<Optional<Activity>> getActivityById(@PathVariable Long id) {
        return ResponseEntity.ok(activityService.getActivityById(id));
    }

    @PostMapping(value = "post")
    public ResponseEntity<String> createActivity(@RequestBody Activity activity) {
        activityService.Create(activity);
        return ResponseEntity.ok(activity.getName() + " Saved Succesfully");
    }

    @PutMapping(value = "put/{id}")
    public ResponseEntity<String> updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
        activityService.Update(id,activity);
        return ResponseEntity.ok(activity.getName() + " updated!");
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteActivity(@PathVariable() Long id) {
        activityService.Delete(id);
        return ResponseEntity.ok(id + "th Activity deleted!");
    }

}
