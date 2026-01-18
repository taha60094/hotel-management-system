package com.hotel.domain;

import java.util.Objects;
import java.util.Optional;

public class Room {
    private final int number;
    private final RoomType roomType;
    private Guest occupant;

    public Room(int number, RoomType roomType) {
        if (number <= 0) {
            throw new IllegalArgumentException("Room number must be positive");
        }
        this.number = number;
        this.roomType = Objects.requireNonNull(roomType);
    }

    public int getNumber() {
        return number;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public Optional<Guest> getOccupant() {
        return Optional.ofNullable(occupant);
    }

    public boolean isOccupied() {
        return occupant != null;
    }

    public void createGuest(Guest guest) {
        if (guest == null) {
            throw new IllegalArgumentException("Guest cannot be null");
        }
        if (isOccupied()) {
            throw new IllegalStateException("Room already occupied");
        }
        this.occupant = guest;
    }

    public void checkout() {
        if (!isOccupied()) {
            throw new IllegalStateException("Room not occupied");
        }
        this.occupant = null;
    }
}
