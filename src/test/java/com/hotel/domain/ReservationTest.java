package com.hotel.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    void createReservation_validData_success() {
        // Arrange
        LocalDate today = LocalDate.now();

        // Act
        Reservation reservation = Reservation.create(today, today.plusDays(1), today.plusDays(3), 1);

        // Assert
        assertEquals(1, reservation.getNumber());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void createReservation_invalidNumber_throwsException(int invalidNumber) {
        // Arrange
        LocalDate today = LocalDate.now();

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> Reservation.create(today, today, today.plusDays(1), invalidNumber));
    }
}
