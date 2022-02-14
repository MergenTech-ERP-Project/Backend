package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Model.ActivityEvaluation;
import com.mergen.vtys.vtysdatabaseap.Repository.ActivityEvaluationRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActivityEvaluationService;
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
@RequestMapping("activityevaluation")
@RequiredArgsConstructor
public class ActivityEvaluationController {

    @Autowired
    private ActivityEvaluationService activityEvaluationService;

    @GetMapping(value = "evaluations")
    public ResponseEntity<List<ActivityEvaluation>> getActivityEvaluationList(){
        return ResponseEntity.ok((List<ActivityEvaluation>) activityEvaluationService.getActivityEvaluationList());
    }

    @GetMapping(value = "evaluations/{id}")
    public ResponseEntity<Optional<ActivityEvaluation>> getActivityEvaluationById(@PathVariable Long id){

        return ResponseEntity.ok(activityEvaluationService.getActivityEvaluationById(id));
    }

    @PostMapping(value = "post")
    public ResponseEntity<String> createActivityEvaluation(@RequestBody ActivityEvaluation activityEvaluation){
        activityEvaluationService.Create(activityEvaluation);
        return ResponseEntity.ok(activityEvaluation.getEvaluation() + " Saved Successfully");
    }

    @PutMapping(value = "put/{id}")
    public ResponseEntity<String> updateActivityEvaluation(@PathVariable Long id, @RequestBody ActivityEvaluation activityEvaluation){
        activityEvaluationService.Update(id,activityEvaluation);
        return ResponseEntity.ok(activityEvaluation.getEvaluation() + " updated!");
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteActivityEvaluation(@PathVariable() Long id){
        activityEvaluationService.Delete(id);
        return ResponseEntity.ok( id + "th Activity Evaluation deleted!");
    }
}

