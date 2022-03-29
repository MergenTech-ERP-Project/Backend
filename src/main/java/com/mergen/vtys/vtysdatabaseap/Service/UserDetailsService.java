package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.UserDetailsDto;

import java.util.List;

public interface UserDetailsService extends HelperService<UserDetailsDto> {

    List<UserDetailsDto> getUserDetailsList();
    UserDetailsDto getUserDetailsById(Long id);
    UserDetailsDto findTcNo(String tc_no);
    UserDetailsDto FindByUserid(Long user_id);




}
