package com.java_tbt.api.core.models;

import com.java_tbt.api.core.dto.address.AddressDTOCreate;
import com.java_tbt.api.core.dto.address.AddressDTOUpdate;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String firstLine;
    private String secondLine;
    private int number;
    private String zipCode;
    private String complement;

    public Address(AddressDTOCreate address) {
        firstLine = address.firstLine();
        secondLine = address.secondLine();
        number = address.number();
        zipCode = address.zipCode();
        complement = address.complement();
    }

    public Address update(AddressDTOUpdate address) {
        if (address.firstLine() != null) {
            firstLine = address.firstLine();
        }
        if (address.secondLine() != null) {
            secondLine = address.secondLine();
        }
        if (address.number().isPresent()) {
            number = address.number().getAsInt();
        }
        if (address.zipCode() != null) {
            zipCode = address.zipCode();
        }
        if (address.complement() != null) {
            complement = address.complement();
        }
        return this;
    }

}
