package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailsService extends HelperService<UserDetails> {
    List<UserDetails> getUserDetailsList();
    Optional<UserDetails> getUserDetailsById(Long id);

}
