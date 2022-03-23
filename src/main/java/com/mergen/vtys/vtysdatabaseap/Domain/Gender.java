package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    none(0),
    male (1),
    female (2),
    unspecified(3);

    private final int id;

}
