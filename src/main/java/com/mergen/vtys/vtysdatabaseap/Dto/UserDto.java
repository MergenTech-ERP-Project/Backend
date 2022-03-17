package com.mergen.vtys.vtysdatabaseap.Dto;

import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email ;
    private String password;
    private List<ActiveToUser> activeToUsers;
    /*  private String title;
    private String cellphone;
    private int tc_no;*/



}
