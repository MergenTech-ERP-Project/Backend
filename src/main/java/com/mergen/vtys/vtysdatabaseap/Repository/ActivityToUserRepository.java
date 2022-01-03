package com.mergen.vtys.vtysdatabaseap.Repository;

import com.mergen.vtys.vtysdatabaseap.Classes.ActiveToUser;
import com.mergen.vtys.vtysdatabaseap.Classes.User;
import org.springframework.data.repository.CrudRepository;

public interface ActivityToUserRepository extends CrudRepository<ActiveToUser, Long> {
}
