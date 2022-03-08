package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Model.Branch;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.BranchRepository;
import com.mergen.vtys.vtysdatabaseap.Service.BranchService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Data
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("branch")
@RequiredArgsConstructor
@Slf4j
public class BranchController {

    @Autowired
    private BranchService branchService;

    @GetMapping(value = "branches")
    public ResponseEntity<List<Branch>> getBranchList() {
        List<Branch> branchList = branchService.getBranchList();
        log.info("All Branches Returned - {}",branchList);
        return ResponseEntity.ok(branchList);
    }

    @GetMapping(value = "branches/{id}")
    public ResponseEntity<Optional<Branch>> getBranchById(@PathVariable Long id) {
        Optional<Branch> status = branchService.getBranchById(id);
        log.info("Branch Got by ID Status - {}",status);
        return ResponseEntity.ok(status);
    }

    @PostMapping(value = "post")
    public ResponseEntity<Branch> createBranch(@RequestBody Branch branch) {
        Branch status = branchService.Create(branch);
        log.info("Branch Added Status - {}",status);
        return  ResponseEntity.status(HttpStatus.CREATED).body(branch);
    }

    @PutMapping(value = "put/{id}")
    public ResponseEntity<String> updateBranch(@PathVariable Long id, @RequestBody Branch branch) {
        String status = branchService.Update(id,branch);
        log.info("Branch Updated Status - {}",status);
        return ResponseEntity.ok(branch.getBranch_name() + " updated!");
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteBranch(@PathVariable() Long id) {
        String status = branchService.Delete(id);
        log.info("Branch Deleted Status - {}",status);
        return ResponseEntity.ok(id + "th Branch deleted!");
    }

}

    