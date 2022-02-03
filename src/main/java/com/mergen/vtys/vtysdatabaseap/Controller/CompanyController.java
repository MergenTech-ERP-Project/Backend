package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Classes.Company;
import com.mergen.vtys.vtysdatabaseap.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("company")

public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("companies")
    public List<Company> getCompanyList() {
        return (List<Company>) companyRepository.findAll();
    }

    @GetMapping("companies/{id}")
    public Optional<Company> getCompanyByID(@PathVariable Long id) {
        return companyRepository.findById(id);
    }

    @PostMapping("post")
    public String createCompany(@RequestBody Company company) {
        companyRepository.save(company);
        return  company.getCompany_name() + " Saved Succesfully";
    }

    @PutMapping("put/{id}")
    public String updateCompany(@PathVariable Long id, @RequestBody Company company){
        companyRepository.save(company);
        return company.getCompany_name() + " updated!";
    }
    @DeleteMapping("delete/{id}")
    public String deleteCompany(@PathVariable() Long id) {
        companyRepository.deleteById(id);
        return id + "th Company deleted!";
    }
}





    