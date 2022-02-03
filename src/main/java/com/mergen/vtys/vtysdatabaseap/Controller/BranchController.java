package com.mergen.vtys.vtysdatabaseap.Controller;


import com.mergen.vtys.vtysdatabaseap.Classes.Branch;
import com.mergen.vtys.vtysdatabaseap.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("branch")
public class BranchController {

    @Autowired
    private BranchRepository branchRepository;
    @GetMapping("branches")
    public List<Branch> getBranchList() {
        return (List<Branch>) branchRepository.findAll();
    }


    @GetMapping("branches/{id}")
    public Optional<Branch> getBranchById(@PathVariable Long id) {
        return branchRepository.findById(id);
    }

    @PostMapping("post")
    public String createBranch(@RequestBody Branch branch) {
        branchRepository.save(branch);
        return  branch.getBranch_name() + " Saved Succesfully";
    }

    @PutMapping("put/{id}")
    public String updateBranch(@PathVariable Long id, @RequestBody Branch branch) {
        branchRepository.save(branch);
        return branch.getBranch_name() + " updated!";
    }

    @DeleteMapping("delete/{id}")
    public String deleteBranch(@PathVariable() Long id) {
        branchRepository.deleteById(id);
        return id + "th Branch deleted!";
    }

}

    