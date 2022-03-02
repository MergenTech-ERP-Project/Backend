package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Departmants {

    none (0),
    software (1),
    support(2),
    management(3);

    private final int id;

}
