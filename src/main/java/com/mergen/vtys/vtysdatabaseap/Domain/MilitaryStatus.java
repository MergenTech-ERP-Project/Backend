package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum MilitaryStatus {
    none,
    done,
    notDone,
    exempt,
    deferred,
}
