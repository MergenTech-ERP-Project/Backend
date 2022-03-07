package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Advice.ExpectionResponse;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.UserRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserService;
import com.mergen.vtys.vtysdatabaseap.dto.UserDto;
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
        if (user.isPresent()){
            return modelMapper.map(user.get(),UserDto.class);
        }
        else
        throw new IllegalArgumentException(id + " Fail" + " And Get User by ID Fail!");

    }

    @Override
    public UserDto getUserByName(String name){
        Optional<User> user = userRepository.findByName(name);
        if (user.isPresent()){
            return modelMapper.map(user.get(),UserDto.class);
        }
        else
        throw new IllegalArgumentException(name + " Auth Fail");

    }

    @Override
    public UserDto getUserNameAndPassword(String name, String password) {
        Optional<User> user = userRepository.findNameAndPassword(name,password);
        if (user.isPresent()){
            return modelMapper.map(user.get(),UserDto.class);
        }
        else
        throw new IllegalArgumentException(name + password + " Auth Fail!");

    }


    @Override
    public UserDto getUserEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.findEmailAndPassword(email,password);
        if (user.isPresent()){
            return modelMapper.map(user.get(),UserDto.class);
        }
        else
            throw new IllegalArgumentException(email + password + " Auth Fail!");

    }





        //  Optional<User> _user = userRepository.findEmailAndPassword(model.getEmail(),model.getPassword());

     /*   if (!_user.isPresent()) {
            userRepository.save(model);
            return model;
        } else
            throw new IllegalArgumentException(model + " Already Exist!");*/


    @Override
    public UserDto Create(UserDto model) {
        User user = modelMapper.map(model,User.class);
        return modelMapper.map(userRepository.save(user),UserDto.class);
    }

    @Override
    public UserDto Update(Long id, UserDto model) {
        User user = modelMapper.map(model,User.class);
        Optional<User> _user = userRepository.findById(id);
        if(_user.isPresent()){
            userRepository.save(user);
            return modelMapper.map(_user.get(),UserDto.class);}
        else
        throw new IllegalArgumentException(model + " Update Option Fail!");
    }


    @Override
    public String Delete(Long id) {
        Optional<User> _user = userRepository.findById(id);
        if(_user.isPresent()){
            userRepository.deleteById(id);
            return id.toString();}
        else
        throw new IllegalArgumentException(" Delete Option Fail!");
    }
}
