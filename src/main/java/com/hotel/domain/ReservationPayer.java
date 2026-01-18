package com.hotel.domain;

import java.util.Objects;

public class ReservationPayer {
    private final CreditCard creditCardDetails;
    private final Identity id;

    private ReservationPayer(CreditCard creditCardDetails, Identity id) {
        this.creditCardDetails = Objects.requireNonNull(creditCardDetails);
        this.id = Objects.requireNonNull(id);
    }

    public static ReservationPayer create(CreditCard creditCardDetails, Identity id) {
        return new ReservationPayer(creditCardDetails, id);
    }

    public CreditCard getCreditCardDetails() {
        return creditCardDetails;
    }

    public Identity getId() {
        return id;
    }
}
