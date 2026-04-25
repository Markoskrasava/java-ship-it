package ru.yandex.practicum.delivery;

import java.util.Objects;

public class StandartParcel extends Parcel {
    private static final int fixSum = 2;

    public StandartParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    public int weight() {
        return weight;
    }


    @Override
    public int calculateDeliveryCost() {
        return weight * fixSum;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public String toString() {
        return super.toString() + "]";
    }
}
