package ru.yandex.practicum.delivery;

import java.util.Objects;

public class PerishableParcel extends Parcel {
    private int timeToLive;
    private static final int fixSum = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public int weight() {
        return weight;
    }


    @Override
    public int calculateDeliveryCost() {
        return weight * fixSum;
    }

    public boolean isExpired(int currentDay) {
        return (sendDay + timeToLive) < currentDay;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        if (o == null || getClass() != o.getClass()) return false;
        PerishableParcel that = (PerishableParcel) o;
        return timeToLive == that.timeToLive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timeToLive);
    }

    @Override
    public String toString() {
        return super.toString() + ", Срок годности=" + timeToLive + "]";
    }


}
