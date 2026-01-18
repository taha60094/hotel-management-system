package com.hotel.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HotelTest {

    @Test
    void available_whenEnoughRooms_returnsTrue() {
        // Arrange
        Hotel hotel = new Hotel(new Name("Test Hotel"));
        RoomType type = new RoomType(RoomKind.SINGLE, new Money(2000));
        hotel.addRoom(new Room(1, type));
        hotel.addRoom(new Room(2, type));

        // Act
        boolean result = hotel.available(type, new HowMany(2));

        // Assert
        assertTrue(result);
    }

    @Test
    void available_whenNotEnoughRooms_returnsFalse() {
        // Arrange
        Hotel hotel = new Hotel(new Name("Test Hotel"));
        RoomType type = new RoomType(RoomKind.SINGLE, new Money(2000));
        hotel.addRoom(new Room(1, type));

        // Act
        boolean result = hotel.available(type, new HowMany(2));

        // Assert
        assertFalse(result);
    }
}
