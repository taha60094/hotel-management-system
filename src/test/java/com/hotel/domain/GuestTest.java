package com.hotel.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuestTest {

    @Test
    void createGuest_validData_success() {
        Guest guest = Guest.create(new Name("Sara"), new Address("Karachi"));
        assertEquals("Sara", guest.getName().getValue());
    }

    @Test
    void createGuest_nullName_throwsException() {
        assertThrows(NullPointerException.class,
                () -> Guest.create(null, new Address("Islamabad")));
    }
}

