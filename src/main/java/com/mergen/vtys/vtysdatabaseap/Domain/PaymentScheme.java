package com.mergen.vtys.vtysdatabaseap.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentScheme {
    none,
    yearly,
    monthly,
    weekly,
    daily,
    hourly,
}