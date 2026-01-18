package com.hotel.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationPayerTest {

    @Test
    void createReservationPayer_validData_success() {
        // Arrange & Act
        ReservationPayer payer = ReservationPayer.create(
                new CreditCard("1111"),
                new Identity("CNIC-1")
        );

        // Assert
        assertNotNull(payer);
    }
}
