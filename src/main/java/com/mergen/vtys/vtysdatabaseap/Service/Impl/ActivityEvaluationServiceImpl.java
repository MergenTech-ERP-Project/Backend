package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.ActivityEvaluation;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.ActivityEvaluationRepository;
import com.mergen.vtys.vtysdatabaseap.Repository.UserRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActivityEvaluationService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class ActivityEvaluationServiceImpl implements ActivityEvaluationService {

    private final ActivityEvaluationRepository activityEvaluationRepository;

    @Override
    public List<ActivityEvaluation> getActivityEvaluationList() {
        try {
            return (List<ActivityEvaluation>) activityEvaluationRepository.findAll();
        }
        catch(Exception e){
                throw new IllegalArgumentException("internal server error");
            }

        }

    @Override
    public Optional<ActivityEvaluation> getActivityEvaluationById(Long id) {
        Optional<ActivityEvaluation> activityEvaluation = activityEvaluationRepository.findById(id);
        return activityEvaluation.isPresent() ? activityEvaluation : null;
    }

  /*  @Override
    public String createActivityEvaluation(ActivityEvaluation activityEvaluation) {
        activityEvaluationRepository.save(activityEvaluation);
        return activityEvaluation.getEvaluation();
    }

    @Override
    public String updateActivityEvaluation(Long id, ActivityEvaluation activityEvaluation) {
        Optional<ActivityEvaluation> _activityEvaluation = activityEvaluationRepository.findById(id);
        if(_activityEvaluation.isPresent()){
            activityEvaluationRepository.save(activityEvaluation);
            return activityEvaluation.getEvaluation();}
        return null;
    }

    @Override
    public String deleteActivityEvaluation(Long id) {
        Optional<ActivityEvaluation> activityEvaluation = activityEvaluationRepository.findById(id);
        if(activityEvaluation.isPresent()){
            activityEvaluationRepository.deleteById(id);
            return id.toString();}
        return null;
    }*/

    @Override
    public ActivityEvaluation Create(ActivityEvaluation model) {
        activityEvaluationRepository.save(model);
        return model;
    }

    @Override
    public String Update(Long id, ActivityEvaluation model) {
        Optional<ActivityEvaluation> _activityEvaluation = activityEvaluationRepository.findById(id);
        if(_activityEvaluation.isPresent()){
            activityEvaluationRepository.save(model);
            return model.getEvaluation();}
       throw new IllegalArgumentException();
    }

    @Override
    public String Delete(Long id) {
        Optional<ActivityEvaluation> activityEvaluation = activityEvaluationRepository.findById(id);
        if(activityEvaluation.isPresent()){
            activityEvaluationRepository.deleteById(id);
            return id.toString();}
        throw  new IllegalArgumentException();
    }
}
