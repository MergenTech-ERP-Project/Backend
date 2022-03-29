package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Dto.DepartmentDto;
import com.mergen.vtys.vtysdatabaseap.Model.Department;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface DepartmentService extends HelperService<DepartmentDto>{
    List<DepartmentDto> getDepartmentList();
    DepartmentDto getDepartmentByID(Long id);
    List<DepartmentDto> getDepartmentsByBranchId(@Param("branch_id") Long branch_id);
}
