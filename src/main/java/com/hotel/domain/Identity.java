package com.hotel.domain;

import java.util.Objects;

public final class Identity {
    private final String number;

    public Identity(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Identity cannot be null or blank");
        }
        this.number = number.trim();
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Identity)) return false;
        Identity identity = (Identity) o;
        return number.equals(identity.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
