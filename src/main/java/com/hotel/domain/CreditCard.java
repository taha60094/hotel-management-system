package com.hotel.domain;

import java.util.Objects;

public final class CreditCard {
    private final String number;

    public CreditCard(String number) {
        if (number == null || number.isBlank()) {
            throw new IllegalArgumentException("Credit card number cannot be null or blank");
        }
        this.number = number.trim();
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreditCard)) return false;
        CreditCard that = (CreditCard) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
