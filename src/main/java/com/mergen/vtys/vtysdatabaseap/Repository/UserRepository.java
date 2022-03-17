package com.mergen.vtys.vtysdatabaseap.Repository;

import com.mergen.vtys.vtysdatabaseap.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "SELECT * from public.user Where name = ?1", nativeQuery = true)
    Optional<User> findByName(String name);

    @Query(value = "SELECT * from public.user u Where u.name = ?1 and u.password = ?2", nativeQuery = true)
    Optional<User> findNameAndPassword(String name, String password);
    @Query(value = "SELECT * from public.user u Where u.email = ?1 and u.password = ?2", nativeQuery = true)
    Optional<User> findEmailAndPassword(String email,String password);
    @Query(value = "SELECT * from public.user u Where u.email = ?1 and u.name = ?2", nativeQuery = true)
    Optional<User> findEmailAndName(String email,String name);



}

