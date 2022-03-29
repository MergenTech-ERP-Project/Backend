package com.mergen.vtys.vtysdatabaseap.Service.SecurityServices;

import com.mergen.vtys.vtysdatabaseap.Repository.UserRepository;
import com.mergen.vtys.vtysdatabaseap.Service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class DummyUserService {

    UserRepository userRepository;
        private Map<String, User> users = new HashMap<>();

        @PostConstruct
        public void initialize() {
            users.put("fatih", new User("fatih", "fatih123",new ArrayList<>()));

        }

        public User getUserByUsername(String username) {
            return users.get(username);
        }
    }

