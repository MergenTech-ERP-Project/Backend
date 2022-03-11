package com.mergen.vtys.vtysdatabaseap.Repository;

import com.mergen.vtys.vtysdatabaseap.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
