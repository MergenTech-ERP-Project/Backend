package com.mergen.vtys.vtysdatabaseap.Repository;


import com.mergen.vtys.vtysdatabaseap.Classes.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CompanyRepository extends  CrudRepository<Company, Long>{

}

