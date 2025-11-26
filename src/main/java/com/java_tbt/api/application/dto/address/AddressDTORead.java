package com.java_tbt.api.application.dto.address;

import com.java_tbt.api.core.models.Address;

public record AddressDTORead(
        String firstLine,
        String secondLine,
        int number,
        String zipCode,
        String complement) {

    public AddressDTORead(Address address) {
        this(address.getFirstLine(), address.getSecondLine(), address.getNumber(), address.getZipCode(),
                address.getComplement());
    }

}
