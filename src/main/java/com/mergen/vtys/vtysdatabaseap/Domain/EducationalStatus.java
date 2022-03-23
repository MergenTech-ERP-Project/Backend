package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EducationalStatus  {

    student (0),
    graduate (1),
    none(2);
    private final int id;

}
