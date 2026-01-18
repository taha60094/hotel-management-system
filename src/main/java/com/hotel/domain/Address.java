package com.hotel.domain;

import java.util.Objects;

public final class Address {
    private final String value;

    public Address(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Address cannot be null or blank");
        }
        this.value = value.trim();
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return value.equals(address.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
