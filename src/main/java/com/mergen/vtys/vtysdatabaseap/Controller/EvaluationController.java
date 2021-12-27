package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Classes.ActivityEvaluation;
import com.mergen.vtys.vtysdatabaseap.Repository.ActivityEvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("activityevaluation")
public class EvaluationController {

    @Autowired
    private ActivityEvaluationRepository activityEvaluationRepository;

    @GetMapping("evaluations")
    public List<ActivityEvaluation> getActivityEvaluationList(){
        return (List<ActivityEvaluation>) activityEvaluationRepository.findAll();
    }

    @GetMapping("evaluations/{id}")
    public Optional<ActivityEvaluation> getActivityEvaluationById(@PathVariable Long id){

        return activityEvaluationRepository.findById(id);
    }

    @PostMapping("post")
    public String createActivityEvaluation(@RequestBody ActivityEvaluation activityEvaluation){
        activityEvaluationRepository.save(activityEvaluation);
        return activityEvaluation.getEvaluation() + " Saved Successfully";
    }

    @PutMapping("put/{id}")
    public String updateActivityEvaluation(@PathVariable Long id, @RequestBody ActivityEvaluation activityEvaluation){
        activityEvaluationRepository.save(activityEvaluation);
        return activityEvaluation.getEvaluation() + " updated!";
    }

    @DeleteMapping("delete/{id}")
    public String deleteActivityEvaluation(@PathVariable() Long id){
        activityEvaluationRepository.deleteById(id);
        return id + "th Activity Evaluation deleted!";
    }
}

