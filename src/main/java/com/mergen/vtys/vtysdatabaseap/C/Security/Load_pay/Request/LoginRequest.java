package com.mergen.vtys.vtysdatabaseap.C.Security.Load_pay.Request;


import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class LoginRequest {


    @NotBlank
    private String password;
    @NotBlank
    private  String  email;

}

    