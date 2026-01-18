package com.hotel.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    @Test
    void createGuest_validData_success() {
        // Arrange & Act
        Guest guest = Guest.create(new Name("Sara"), new Address("Karachi"));

        // Assert
        assertEquals("Sara", guest.getName().getValue());
    }

    @Test
    void createGuest_nullName_throwsException() {
        // Arrange & Act & Assert
        assertThrows(NullPointerException.class,
                () -> Guest.create(null, new Address("Islamabad")));
    }
}
