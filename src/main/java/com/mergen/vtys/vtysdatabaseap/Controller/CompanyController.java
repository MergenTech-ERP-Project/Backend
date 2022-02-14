package com.mergen.vtys.vtysdatabaseap.Controller;

import com.mergen.vtys.vtysdatabaseap.Model.Company;
import com.mergen.vtys.vtysdatabaseap.Repository.CompanyRepository;
import com.mergen.vtys.vtysdatabaseap.Service.CompanyService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("company")
@RequiredArgsConstructor
public class CompanyController {

    @Autowired
    private final CompanyService companyService;

    @GetMapping(value = "companies")
    public ResponseEntity<List<Company>> getCompanyList() {
        return ResponseEntity.ok((List<Company>) companyService.getCompanyList());
    }

    @GetMapping(value = "companies/{id}")
    public ResponseEntity<Optional<Company>> getCompanyByID(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.getCompanyByID(id));
    }

    @PostMapping(value = "post")
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        companyService.Create(company);
        return  ResponseEntity.ok(company.getCompany_name() + " Saved Succesfully");
    }

    @PutMapping(value = "put/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        companyService.Update(id,company);
        return ResponseEntity.ok(company.getCompany_name() + " updated!");
    }
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable() Long id) {
        companyService.Delete(id);
        return ResponseEntity.ok( id + "th Company deleted!");
    }
}





    