package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.UserDetailsDto;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailsService extends HelperService<UserDetailsDto> {

    List<UserDetailsDto> getUserDetailsList();
    UserDetailsDto getUserDetailsById(Long id);
    UserDetailsDto findTcNo(String tc_no);
    UserDetailsDto FindByUserid(Long user_id);




}
