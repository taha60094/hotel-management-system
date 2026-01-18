package com.hotel.domain;

import java.util.*;

public class HotelChain {
    private final Name name;
    private final List<Hotel> hotels = new ArrayList<>();
    private ReservationPayer reservationPayer;

    public HotelChain(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public Name getName() {
        return name;
    }

    public void addHotel(Hotel hotel) {
        hotels.add(Objects.requireNonNull(hotel));
    }

    public Reservation makeReservation(Hotel hotel,
                                       java.time.LocalDate reservationDate,
                                       java.time.LocalDate startDate,
                                       java.time.LocalDate endDate,
                                       int number) {
        ensureCanMakeReservation();
        return hotel.createReservation(reservationDate, startDate, endDate, number);
    }

    public void cancelReservation(Reservation reservation) {
        ensureCanCancelReservation();
        Objects.requireNonNull(reservation);
    }

    public void checkInGuest(Room room, Guest guest) {
        ensureCanCheckInGuest();
        room.createGuest(guest);
    }

    public void checkOutGuest(Room room) {
        ensureCanCheckOutGuest();
        room.checkout();
    }

    public ReservationPayer createReservationPayer(CreditCard card, Identity id) {
        this.reservationPayer = ReservationPayer.create(card, id);
        return reservationPayer;
    }

    private void ensureCanMakeReservation() {
        if (!canMakeReservation()) {
            throw new IllegalStateException("Cannot make reservation");
        }
    }

    private void ensureCanCancelReservation() {
        if (!canCancelReservation()) {
            throw new IllegalStateException("Cannot cancel reservation");
        }
    }

    private void ensureCanCheckInGuest() {
        if (!canCheckInGuest()) {
            throw new IllegalStateException("Cannot check in guest");
        }
    }

    private void ensureCanCheckOutGuest() {
        if (!canCheckOutGuest()) {
            throw new IllegalStateException("Cannot check out guest");
        }
    }

    public boolean canMakeReservation() {
        return reservationPayer != null;
    }

    public boolean canCancelReservation() {
        return reservationPayer != null;
    }

    public boolean canCheckInGuest() {
        return true;
    }

    public boolean canCheckOutGuest() {
        return true;
    }
}
