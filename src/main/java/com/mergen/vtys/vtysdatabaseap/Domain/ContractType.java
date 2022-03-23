package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ContractType {

    timely (0),
    indenfinite (1),
    none(3);
    private final int id;

}
