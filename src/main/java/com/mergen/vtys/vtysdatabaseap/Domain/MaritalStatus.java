package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@AllArgsConstructor
@Slf4j
public enum MaritalStatus {
    none(0),
    married(1),
    single(2),
    unspecified(3);



    private final int id;

    public int getSize()
    {
        return MaritalStatus.values().length;
    }

}


