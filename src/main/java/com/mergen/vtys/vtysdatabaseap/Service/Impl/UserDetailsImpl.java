package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.Company;

import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserDetailsService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;



 @Override
public Optional<UserDetails> getUserDetailsById(Long id){
   Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
   if(userDetails.isPresent()){
       return userDetails;
   }
   else
       throw new IllegalArgumentException(id + " failed" + " Get UserDetails by ID Failed");
   }


    @Override
    public UserDetails Create(UserDetails model) {
     userDetailsRepository.save(model);
        return null;
    }

    @Override
    public String  Update(Long id, UserDetails model) {
        Optional<UserDetails> _userDetails = userDetailsRepository.findById(id);
        if(_userDetails.isPresent()){
            userDetailsRepository.save(model);
            return model.getAddress();}
        else
            throw new IllegalArgumentException(model + " Failed to Update");
    }

    @Override
    public String Delete(Long id) {
        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);

        if(userDetails.isPresent()){
            userDetailsRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException("Delete Option Fails");
    }


    public List<UserDetails> getUserDetailsList() {
        return (List<UserDetails>) userDetailsRepository.findAll();
    }

}