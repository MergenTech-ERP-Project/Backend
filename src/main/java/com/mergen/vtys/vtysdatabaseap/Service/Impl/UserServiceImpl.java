package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Advice.ExpectionResponse;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.UserDetailsRepository;
import com.mergen.vtys.vtysdatabaseap.Repository.UserRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Query(value = "SELECT * from user", nativeQuery = true)
    @Override
    public List<User> getUserLists(){return (List<User>) userRepository.findAll();}


    @Override
    public Optional<User> getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()){
            return user;
        }
        else
        throw new IllegalArgumentException(id + " Fail" + " And Get User by ID Fail!");

    }

    @Override
    public Optional<User> getUserByName(String name){
        Optional<User> user = userRepository.findByName(name);
        if (user.isPresent()){
            return user;
        }
        else
        throw new IllegalArgumentException(name + " Auth Fail");

    }

    @Override
    public Optional<User> getUserNameAndPassword(String name, String password) {
        Optional<User> user = userRepository.findNameAndPassword(name,password);
        if (user.isPresent()){
            return user;
        }
        else
        throw new IllegalArgumentException(name + password + " Auth Fail!");

    }


    @Override
    public Optional<User> getUserEmailAndPassword(String email, String password) {
        Optional<User> user = userRepository.findEmailAndPassword(email,password);
        if (user.isPresent()){
            return user;
        }
        else
            throw new IllegalArgumentException(email + password + " Auth Fail!");

    }

    @Override
    public User Create(User model) {
        Optional<User> _user = userRepository.findEmailAndPassword(model.getEmail(),model.getPassword());

        if (!_user.isPresent()) {
            userRepository.save(model);
            return model;
        } else
            throw new IllegalArgumentException(model + " Already Exist!");
    }

    @Override
    public String Update(Long id, User model) {
        Optional<User> _user = userRepository.findById(id);
        if(_user.isPresent()){
            userRepository.save(model);
            return model.getName();}
        else
        throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            userRepository.deleteById(id);
            return id.toString();}
        else
        throw new IllegalArgumentException(" Delete Option Fail!");
    }
}
