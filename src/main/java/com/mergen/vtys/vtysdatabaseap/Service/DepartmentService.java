package com.mergen.vtys.vtysdatabaseap.Service;

import com.mergen.vtys.vtysdatabaseap.Model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService extends HelperService<Department>{
   List<Department> getDepartmentList();
   Optional<Department> getDepartmentByID(Long id);
}
