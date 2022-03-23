package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BankAccountType {
    none(0),
    drawingAccount (1),
    checkAccount (2),
    other(3);

    private final int id;

}
