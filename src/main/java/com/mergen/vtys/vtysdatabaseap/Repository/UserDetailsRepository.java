package com.mergen.vtys.vtysdatabaseap.Repository;


import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails,Long> {

}
