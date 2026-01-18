package com.hotel.domain;

import java.time.LocalDate;

public class Reservation {
    private final LocalDate reservationDate;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int number;

    private Reservation(LocalDate reservationDate,
                        LocalDate startDate,
                        LocalDate endDate,
                        int number) {
        if (reservationDate == null || startDate == null || endDate == null) {
            throw new IllegalArgumentException("Dates cannot be null");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("End date cannot be before start date");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("Reservation number must be positive");
        }

        this.reservationDate = reservationDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.number = number;
    }

    public static Reservation create(LocalDate reservationDate,
                                     LocalDate startDate,
                                     LocalDate endDate,
                                     int number) {
        return new Reservation(reservationDate, startDate, endDate, number);
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getNumber() {
        return number;
    }
}
