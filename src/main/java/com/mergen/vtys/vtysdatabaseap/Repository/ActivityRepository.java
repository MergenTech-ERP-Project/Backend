package com.mergen.vtys.vtysdatabaseap.Repository;




import com.mergen.vtys.vtysdatabaseap.Classes.Activity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
