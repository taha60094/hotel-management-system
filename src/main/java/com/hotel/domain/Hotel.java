package com.hotel.domain;

import java.util.*;
import java.time.LocalDate;


public class Hotel {
    private final Name name;
    private final List<Room> rooms = new ArrayList<>();

    public Hotel(Name name) {
        this.name = Objects.requireNonNull(name);
    }

    public Name getName() {
        return name;
    }

    public void addRoom(Room room) {
        rooms.add(Objects.requireNonNull(room));
    }

    public boolean available(RoomType type, HowMany howMany) {
        long count = rooms.stream()
                .filter(r -> !r.isOccupied())
                .filter(r -> r.getRoomType().equals(type))
                .count();
        return count >= howMany.getNumber();
    }

    public Reservation createReservation(LocalDate reservationDate,
                                         LocalDate startDate,
                                         LocalDate endDate,
                                         int number) {
        return Reservation.create(reservationDate, startDate, endDate, number);
    }

    public List<Room> getRooms() {
        return Collections.unmodifiableList(rooms);
    }
}
