package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.Branch;
import com.mergen.vtys.vtysdatabaseap.Model.User;
import com.mergen.vtys.vtysdatabaseap.Repository.BranchRepository;
import com.mergen.vtys.vtysdatabaseap.Service.BranchService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    @Override
    public List<Branch> getBranchList() {
        return (List<Branch>) branchRepository.findAll();
    }

    @Override
    public Optional<Branch> getBranchById(Long id) {
        Optional<Branch> branch = branchRepository.findById(id);
        return branch.isPresent() ? branch : null;
    }

   /* @Override
    public String createBranch(Branch branch) {
        branchRepository.save(branch);
        return branch.getBranch_name();
    }

    @Override
    public String updateBranch(Long id, Branch branch) {
        Optional<Branch> _branch = branchRepository.findById(id);
        if(_branch.isPresent()){
            branchRepository.save(branch);
            return branch.getBranch_name();}
        return null;
    }

    @Override
    public String deleteBranch(Long id) {
        Optional<Branch> branch = branchRepository.findById(id);
        if(branch.isPresent()){
            branchRepository.deleteById(id);
            return id.toString();}
        return null;
    }*/

    @Override
    public Branch Create(Branch model) {
        branchRepository.save(model);
        return model;
    }

    @Override
    public String Update(Long id, Branch model) {
        Optional<Branch> _branch = branchRepository.findById(id);
        if(_branch.isPresent()){
            branchRepository.save(model);
            return model.getBranch_name();}
        return null;
    }

    @Override
    public String Delete(Long id) {
        Optional<Branch> branch = branchRepository.findById(id);
        if(branch.isPresent()){
            branchRepository.deleteById(id);
            return id.toString();}
        return null;
    }
}
