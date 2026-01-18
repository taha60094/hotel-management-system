package com.hotel.domain;

import java.util.Objects;

public class RoomType {
    private final RoomKind kind;
    private final Money cost;

    public RoomType(RoomKind kind, Money cost) {
        this.kind = Objects.requireNonNull(kind);
        this.cost = Objects.requireNonNull(cost);
    }

    public RoomKind getKind() {
        return kind;
    }

    public Money getCost() {
        return cost;
    }
}
