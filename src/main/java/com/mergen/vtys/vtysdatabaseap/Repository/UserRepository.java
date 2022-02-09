package com.mergen.vtys.vtysdatabaseap.Repository;



import com.mergen.vtys.vtysdatabaseap.Classes.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByNameAndPassword(String name , String password);
}

