package com.hotel.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void createGuest_whenRoomFree_success() {
        // Arrange
        RoomType type = new RoomType(RoomKind.SINGLE, new Money(3000));
        Room room = new Room(101, type);
        Guest guest = Guest.create(new Name("Ali"), new Address("Lahore"));

        // Act
        room.createGuest(guest);

        // Assert
        assertTrue(room.isOccupied());
    }

    @Test
    void createGuest_whenRoomOccupied_throwsException() {
        // Arrange
        RoomType type = new RoomType(RoomKind.SINGLE, new Money(3000));
        Room room = new Room(101, type);
        Guest guest = Guest.create(new Name("Ali"), new Address("Lahore"));
        room.createGuest(guest);

        // Act & Assert
        assertThrows(IllegalStateException.class,
                () -> room.createGuest(guest));
    }
}
