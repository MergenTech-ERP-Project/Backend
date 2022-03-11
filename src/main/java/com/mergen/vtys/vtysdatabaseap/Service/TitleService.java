package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.Department;
import com.mergen.vtys.vtysdatabaseap.Model.Title;

import java.util.List;
import java.util.Optional;

public interface TitleService  extends HelperService<Title> {
    List<Title> getTitleList();
    Optional<Title> getTitleByID(Long id);
}
