package com.hotel.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class HotelChainTest {

    @Test
    void makeReservation_withoutPayer_throwsException() {
        // Arrange
        HotelChain chain = new HotelChain(new Name("Chain"));
        Hotel hotel = new Hotel(new Name("Hotel"));

        // Act & Assert
        assertThrows(IllegalStateException.class,
                () -> chain.makeReservation(hotel, LocalDate.now(),
                        LocalDate.now(), LocalDate.now().plusDays(1), 1));
    }

    @Test
    void makeReservation_withPayer_success() {
        // Arrange
        HotelChain chain = new HotelChain(new Name("Chain"));
        Hotel hotel = new Hotel(new Name("Hotel"));
        chain.createReservationPayer(new CreditCard("123"), new Identity("ID1"));

        // Act
        Reservation reservation = chain.makeReservation(hotel,
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(2),
                1);

        // Assert
        assertNotNull(reservation);
    }
}
