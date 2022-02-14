package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Model.Branch;
import com.mergen.vtys.vtysdatabaseap.Repository.BranchRepository;
import com.mergen.vtys.vtysdatabaseap.Service.BranchService;
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
@RequestMapping("branch")
@RequiredArgsConstructor
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping(value = "branches")
    public ResponseEntity<List<Branch>> getBranchList() {
        return ResponseEntity.ok((List<Branch>) branchService.getBranchList());
    }

    @GetMapping(value = "branches/{id}")
    public ResponseEntity<Optional<Branch>> getBranchById(@PathVariable Long id) {
        return ResponseEntity.ok(branchService.getBranchById(id));
    }

    @PostMapping(value = "post")
    public ResponseEntity<String> createBranch(@RequestBody Branch branch) {
        branchService.Create(branch);
        return  ResponseEntity.ok(branch.getBranch_name()+ " Saved Succesfully");
    }

    @PutMapping(value = "put/{id}")
    public ResponseEntity<String> updateBranch(@PathVariable Long id, @RequestBody Branch branch) {
        branchService.Update(id,branch);
        return ResponseEntity.ok(branch.getBranch_name() + " updated!");
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteBranch(@PathVariable() Long id) {
        branchService.Delete(id);
        return ResponseEntity.ok(id + "th Branch deleted!");
    }

}

    