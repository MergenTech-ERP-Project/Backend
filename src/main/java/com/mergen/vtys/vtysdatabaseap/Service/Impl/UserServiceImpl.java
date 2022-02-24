package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Advice.ExpectionResponse;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.UserRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.*;


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
        throw new IllegalArgumentException(id + " failed" + " Get User by ID Failed");

    }

    @Override
    public Optional<User> getUserByName(String name){
        Optional<User> user = userRepository.findByName(name);
        if (user.isPresent()){
            return user;
        }
        else
        throw new IllegalArgumentException("");

    }

    @Override
    public Optional<User> getUserNameAndPassword(String name, String password) {
        Optional<User> user = userRepository.findNameAndPassword(name,password);
        if (user.isPresent()){
            return user;
        }
        else
        throw new IllegalArgumentException(name + password + " Auth Failed");

    }

    /*@Override
    public String createUser(User user){
        userRepository.save(user);
        return user.getName();
    }

    @Override
    public String updateUser(Long id, User user){
        Optional<User> _user = userRepository.findById(id);
        if(_user.isPresent()){
            userRepository.save(user);
            return user.getName();}
        return null;

    }

    @Override
    public String deleteUser(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return id.toString();}
        return null;
    }*/

    @Override
    public User Create(User model) {
        Optional<User> _user = userRepository.findNameAndPassword(model.getName(),model.getPassword());

        if (!_user.isPresent()) {
            userRepository.save(model);

            return model;
        } else
            throw new IllegalArgumentException(model + "  already exist");
    }

    @Override
    public String Update(Long id, User model) {
        Optional<User> _user = userRepository.findById(id);
        if(_user.isPresent()){
            userRepository.save(model);
            return model.getName();}
        else
        throw new IllegalArgumentException(model + " Failed to Update");
    }

    @Override
    public String Delete(Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isPresent()){
            userRepository.deleteById(id);
            return id.toString();}
        else
        throw new IllegalArgumentException("Delete Option Fails");
    }
}
