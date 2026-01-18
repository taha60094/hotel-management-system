package com.hotel.domain;

public final class HowMany {
    private final int number;

    public HowMany(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("HowMany must be positive");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
