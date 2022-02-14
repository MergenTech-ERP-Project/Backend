package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import com.mergen.vtys.vtysdatabaseap.Repository.ActiveToUserRepository;
import com.mergen.vtys.vtysdatabaseap.Service.ActiveToUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class ActiveToUserServiceImpl implements ActiveToUserService {

    private final ActiveToUserRepository activityToUserRepository;

    @Override
    public List<ActiveToUser> getActivityList() {
        return (List<ActiveToUser>) activityToUserRepository.findAll();
    }

    @Override
    public Optional<ActiveToUser> getActivityById(Long id) {
        Optional<ActiveToUser> activeToUser = activityToUserRepository.findById(id);
        return activeToUser.isPresent() ? activeToUser : null;
    }

    @Override
    public String Create(ActiveToUser model) {
        activityToUserRepository.save(model);
        return model.getActivity().toString();
    }

    @Override
    public String Update(Long id, ActiveToUser model) {
        Optional<ActiveToUser> activeToUser = activityToUserRepository.findById(id);
        if(activeToUser.isPresent()){
            activityToUserRepository.save(model);
            return model.getActivity().toString();}
        return null;
    }

    @Override
    public String Delete(Long id) {
        Optional<ActiveToUser> activeToUser = activityToUserRepository.findById(id);
        if(activeToUser.isPresent()){
            activityToUserRepository.deleteById(id);
            return id.toString();}
        return null;
    }
}
