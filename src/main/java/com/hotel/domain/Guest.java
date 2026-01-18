package com.hotel.domain;

import java.util.Objects;

public class Guest {
    private final Name name;
    private final Address addressDetails;

    private Guest(Name name, Address addressDetails) {
        this.name = Objects.requireNonNull(name);
        this.addressDetails = Objects.requireNonNull(addressDetails);
    }

    public static Guest create(Name name, Address addressDetails) {
        return new Guest(name, addressDetails);
    }

    public Name getName() {
        return name;
    }

    public Address getAddressDetails() {
        return addressDetails;
    }
}
