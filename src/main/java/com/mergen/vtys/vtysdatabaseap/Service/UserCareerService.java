package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.UserCareerDto;
import com.mergen.vtys.vtysdatabaseap.Model.Title;
import com.mergen.vtys.vtysdatabaseap.Model.UserCareer;
import java.util.List;
import java.util.Optional;

public interface UserCareerService extends HelperService<UserCareerDto> {
    List<UserCareerDto> getUserCareerList();
    UserCareerDto getUserCareerByID(Long id);
}
