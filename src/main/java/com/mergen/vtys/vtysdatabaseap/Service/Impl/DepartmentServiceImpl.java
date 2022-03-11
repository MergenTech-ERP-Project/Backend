package com.mergen.vtys.vtysdatabaseap.Service.Impl;

import com.mergen.vtys.vtysdatabaseap.Model.Company;
import com.mergen.vtys.vtysdatabaseap.Model.Department;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import com.mergen.vtys.vtysdatabaseap.Repository.DepartmentRepository;
import com.mergen.vtys.vtysdatabaseap.Service.DepartmentService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private  final DepartmentRepository departmentRepository;


    @Override
    public List<Department> getDepartmentList(){
        return   departmentRepository.findAll();
    }
    @Override
    public Optional<Department> getDepartmentByID(Long id) {
        Optional<Department> department = Optional.ofNullable(departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Find by Id Internal Error")));
        return department;

    }

    @Override
    public Department Create(Department model) {
        departmentRepository.save(model);
             return model;
    }

    @Override
    public String  Update(Long id, Department model) {
        Optional<Department> _departmant = departmentRepository.findById(id);
        if(_departmant.isPresent()){
           departmentRepository.save(model);
            return model.getDepartment_name();}
        else
            throw new IllegalArgumentException(model + " Update Option Fail!");
    }

    @Override
    public String Delete(Long id) {
        Optional<Department> department_ = departmentRepository.findById(id);

        if(department_.isPresent()){
         departmentRepository.deleteById(id);
            return id.toString();}
        else
            throw new IllegalArgumentException(" Delete Option Fail!");
    }




}




    