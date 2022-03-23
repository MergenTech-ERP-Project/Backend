package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TypeOfWorking {
    none,
    fullTime,
    partTime,
    temporary,
    contract,
    freelancer,
    intern,
    mobile,
}
