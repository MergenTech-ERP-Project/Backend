package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Dto.UserDto;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.UserRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Query(value = "SELECT * from user", nativeQuery = true)
    @Override
    public List<UserDto> getUserLists(){
        List<User> userList = (List<User>) userRepository.findAll();
        return userList.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            return modelMapper.map(user.get(),UserDto.class);
        throw new IllegalArgumentException(id + " Fail" + " And Get User by ID Fail!");
    }

    @Override
    public UserDto getUserByName(String name){
        Optional<User> user = userRepository.findByName(name);
        if (user.isPresent())
            return modelMapper.map(user.get(),UserDto.class);
        throw new IllegalArgumentException(name + " Auth Fail");
    }

    @Override
    public UserDto getUserNameAndPassword(String name, String password) {
        Optional<User> user = userRepository.findNameAndPassword(name,password);
        if (user.isPresent())
            return modelMapper.map(user.get(),UserDto.class);
        throw new IllegalArgumentException(name + password + " Auth Fail!");
    }

    @Override
    public UserDto getUserEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.findEmailAndPassword(email,password);
        if (user.isPresent())
            return modelMapper.map(user.get(),UserDto.class);
        throw new IllegalArgumentException(email + password + " Auth Fail!");
    }

    @Override
    public UserDto Create(UserDto model) {
        User user = modelMapper.map(model,User.class);
        Optional<User> _user = userRepository.findEmailAndName(model.getEmail(), model.getName());
        if(_user.isEmpty())
            return modelMapper.map(userRepository.save(user),UserDto.class);
        throw new IllegalArgumentException(model + " Create Option Fail!");
    }

    @Override
    public String Update(Long id, UserDto model) {
        User user = modelMapper.map(model,User.class);
        Optional<User> _user = userRepository.findById(id);
        if(_user.isPresent()){
            if(id.equals(model.getId())) {
                userRepository.save(user);
                return user.getName() + " Updated!";}}
            throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return id.toString();}
        else throw new IllegalArgumentException(" Delete Option Fail!");
    }
}
