package com.mergen.vtys.vtysdatabaseap.Service.Impl;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserDetailsService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;


    @Override
    public Optional<UserDetails> getUserDetailsById(Long id){
        Optional<UserDetails> userDetails = Optional.ofNullable(userDetailsRepository.findById(id).orElseThrow(() -> new IllegalStateException("Find by Id Internal Error")));

        return userDetails;
    }


    @Override
    public UserDetails Create(UserDetails model) {

        if(userDetailsRepository.existsByEmail(model.getTc_no())){
            throw new IllegalArgumentException("TC No Saved Before");
        }
        else
        userDetailsRepository.save(model);
        return model;
    }

    @Override
    public String  Update(Long id, UserDetails model) {
        Optional<UserDetails> _userDetails = userDetailsRepository.findById(id);
        if(_userDetails.isPresent()){
            userDetailsRepository.save(model);
            return model.getAddress();}
        else
            throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);

        if(userDetails.isPresent()){
            userDetailsRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }

    @Override
    public List<UserDetails> getUserDetailsList() {
        return userDetailsRepository.findAll();
    }

}