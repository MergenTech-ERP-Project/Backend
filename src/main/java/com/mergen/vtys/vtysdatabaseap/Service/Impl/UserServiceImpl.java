package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.UserRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getUserList(){return (List<User>) userRepository.findAll();}

    @Override
    public Optional<User> getUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.isPresent() ? user : null;
    }

    @Override
    public Optional<User> getUserByName(String name){
        Optional<User> user = userRepository.findByName(name);
        return user.isPresent() ? user : null;
    }

    @Override
    public Optional<User> getUserByNameAndPassword(String name, String password) {
        Optional<User> user = userRepository.findByNameAndPassword(name,password);
        return user.isPresent() ? user : null;
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
    public String Create(User model) {
        userRepository.save(model);
        return model.getName();
    }

    @Override
    public String Update(Long id, User model) {
        Optional<User> _user = userRepository.findById(id);
        if(_user.isPresent()){
            userRepository.save(model);
            return model.getName();}
        return null;
    }

    @Override
    public String Delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return id.toString();}
        return null;
    }
}
