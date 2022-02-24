package com.mergen.vtys.vtysdatabaseap.Repository;

import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActiveToUserRepository extends CrudRepository<ActiveToUser, Long> {
    @Query(value = "SELECT activetouser.activity_ids,activity.name,activity.place,activity.datetime FROM activetouser LEFT JOIN activity ON activity.id = activetouser.activity_ids Where user_ids= ?1 ",nativeQuery = true)
    List<Long> getUsersEnrolled(Long id);
}
