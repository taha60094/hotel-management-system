package com.hotel.app;

import com.hotel.domain.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create hotel chain
        HotelChain chain = new HotelChain(new Name("Pearl Hotels"));

        // Create hotel
        Hotel hotel = new Hotel(new Name("Pearl Continental Lahore"));
        chain.addHotel(hotel);

        // Create room types
        RoomType single = new RoomType(RoomKind.SINGLE, new Money(5000));
        RoomType doubleRoom = new RoomType(RoomKind.DOUBLE, new Money(8000));

        // Add rooms
        hotel.addRoom(new Room(101, single));
        hotel.addRoom(new Room(102, single));
        hotel.addRoom(new Room(201, doubleRoom));

        // Create reservation payer
        ReservationPayer payer = chain.createReservationPayer(
                new CreditCard("1234-5678-9999"),
                new Identity("CNIC-35202")
        );

        // Check availability
        boolean available = hotel.available(single, new HowMany(2));
        System.out.println("Two single rooms available? " + available);

        // Make reservation
        Reservation reservation = chain.makeReservation(
                hotel,
                LocalDate.now(),
                LocalDate.now().plusDays(1),
                LocalDate.now().plusDays(3),
                1
        );
        System.out.println("Reservation created with number: " + reservation.getNumber());

        // Create guest
        Guest guest = Guest.create(
                new Name("Ali Khan"),
                new Address("Model Town, Lahore")
        );

        // Check in
        Room room = hotel.getRooms().get(0);
        chain.checkInGuest(room, guest);
        System.out.println("Guest checked into room: " + room.getNumber());

        // Check out
        chain.checkOutGuest(room);
        System.out.println("Guest checked out of room: " + room.getNumber());
    }
}
