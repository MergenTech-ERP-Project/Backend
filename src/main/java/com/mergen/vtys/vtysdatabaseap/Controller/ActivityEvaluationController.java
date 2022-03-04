package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Model.ActivityEvaluation;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.ActivityEvaluationRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActivityEvaluationService;
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
@RequestMapping("activityevaluation")
@RequiredArgsConstructor
@Slf4j
public class ActivityEvaluationController {

    @Autowired
    private ActivityEvaluationService activityEvaluationService;

    @GetMapping(value = "evaluations")
    public ResponseEntity<List<ActivityEvaluation>> getActivityEvaluationList(){
        List<ActivityEvaluation> activityEvaluationList = activityEvaluationService.getActivityEvaluationList();
        log.info("All Activity Evaluations Returned - {}",activityEvaluationList);
        return ResponseEntity.ok(activityEvaluationList);
    }

    @GetMapping(value = "evaluations/{id}")
    public ResponseEntity<Optional<ActivityEvaluation>> getActivityEvaluationById(@PathVariable Long id){
        Optional<ActivityEvaluation> status = activityEvaluationService.getActivityEvaluationById(id);
        log.info("Activity Evaluation Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "post")
    public ResponseEntity<String> createActivityEvaluation(@RequestBody ActivityEvaluation activityEvaluation){
        ActivityEvaluation status = activityEvaluationService.Create(activityEvaluation);
        log.info("Activity Evaluation Added Status - {}",status);
        return ResponseEntity.ok(activityEvaluation.getEvaluation() + " created");
       // return ResponseEntity.status(HttpStatus.CREATED).body(activityEvaluation);
    }

    @PutMapping(value = "put/{id}")
    public ResponseEntity<String> updateActivityEvaluation(@PathVariable Long id, @RequestBody ActivityEvaluation activityEvaluation){
        String status = activityEvaluationService.Update(id,activityEvaluation);
        log.info("Activity Evaluation Updated Status - {}",status);
        return ResponseEntity.ok(activityEvaluation.getEvaluation() + " updated!");
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteActivityEvaluation(@PathVariable() Long id){
        String status = activityEvaluationService.Delete(id);
        log.info("Activity Evaluation Deleted Status - {}",status);
        return ResponseEntity.ok( id + "th Activity Evaluation deleted!");
    }
}

