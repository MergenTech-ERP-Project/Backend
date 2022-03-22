package com.mergen.vtys.vtysdatabaseap.Service.Impl;
import com.mergen.vtys.vtysdatabaseap.Dto.UserDetailsDto;
import com.mergen.vtys.vtysdatabaseap.Dto.UserDto;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserDetailsService;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetailsService {

    private final UserDetailsRepository userDetailsRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetailsDto getUserDetailsById(Long id){
        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
        if (userDetails.isPresent())
            return modelMapper.map(userDetails.get(), UserDetailsDto.class);
        throw new IllegalArgumentException(id + " Fail" + " And Get User Details by ID Fail!");
    }

    @Override
    public UserDetailsDto Create(UserDetailsDto model) {
        UserDetails userDetails = modelMapper.map(model,UserDetails.class);
        boolean _userDetails = userDetailsRepository.existsByEmail(model.getTc_no());
        if(!_userDetails)
            return modelMapper.map(userDetailsRepository.save(userDetails),UserDetailsDto.class);
        throw new IllegalArgumentException(model + " Create Option Fail!");
    }

    @Override
    public String Update(Long id, UserDetailsDto model) {
        UserDetails userDetails = modelMapper.map(model,UserDetails.class);
        Optional<UserDetails> _userDetails = userDetailsRepository.findById(id);
        if(_userDetails.isPresent()){
            if(id.equals(model.getId())) {
                userDetailsRepository.save(userDetails);
                return "TC No:" + userDetails.getTc_no() + " Updated!";}}
        throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<UserDetails> userDetails = userDetailsRepository.findById(id);
        if(userDetails.isPresent()){
            userDetailsRepository.deleteById(id);
            return id.toString();}
        else throw new IllegalArgumentException(" Delete Option Fail!");
    }

    @Override
    public List<UserDetailsDto> getUserDetailsList() {
        List<UserDetails> userDetailsList = (List<UserDetails>) userDetailsRepository.findAll();
        return userDetailsList.stream().map(userDetails -> modelMapper.map(userDetails,UserDetailsDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDetailsDto findTcNo(String tc_no){
        Optional<UserDetails> userDetails = userDetailsRepository.findTcNo(tc_no);
        if (userDetails.isPresent())
            return modelMapper.map(userDetails.get(),UserDetailsDto.class);
        throw new IllegalArgumentException("TC No:" + tc_no + " Auth Fail");
    }

    @Override
    public UserDetailsDto FindByUserid(Long user_id){
        Optional<UserDetails> userDetails = userDetailsRepository.FindByUserid(user_id);
        if (userDetails.isPresent())
            return modelMapper.map(userDetails.get(),UserDetailsDto.class);
        throw new IllegalArgumentException("User id:" + user_id + " Auth Fail");
    }
}