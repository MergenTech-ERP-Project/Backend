package com.mergen.vtys.vtysdatabaseap.Dto;

import com.mergen.vtys.vtysdatabaseap.Domain.MaritalStatus;
import lombok.Data;

@Data
public class UserDetailsDto {

    private Long id;
    private String tc_no;
    private Long user_id;
    private String dateofbirth;
    private MaritalStatus maritalstatus;
    private Long numberofkids;
    // private DisabledDegree degree_of_disability;
    //  private Gender gender;

}