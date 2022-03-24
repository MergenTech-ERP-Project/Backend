package com.mergen.vtys.vtysdatabaseap.Dto;

import com.mergen.vtys.vtysdatabaseap.Model.ActiveToUser;
import com.mergen.vtys.vtysdatabaseap.Model.UserDetails;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String email ;
    private String title;
    private String cellphone;
    private String password;
    private List<ActiveToUser> activeToUsers;
    private List<UserDetails> userDetails;

}
