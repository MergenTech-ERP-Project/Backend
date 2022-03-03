package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountType {

    drawingAccount (0),
    checkAccount (1),
    other(2);

    private final int id;

}
