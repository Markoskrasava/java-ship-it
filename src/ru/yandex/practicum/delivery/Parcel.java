package ru.yandex.practicum.delivery;

import java.util.Objects;

public abstract class Parcel {
    protected String description; //добавьте реализацию и другие необходимые классы
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public abstract int calculateDeliveryCost();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return weight == parcel.weight && sendDay == parcel.sendDay && Objects.equals(description, parcel.description) && Objects.equals(deliveryAddress, parcel.deliveryAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public String toString() {
        return  "[Описание='" + description + '\'' +
                ", Вес=" + weight +
                ", Адрес доставки='" + deliveryAddress + '\'' +
                ", День отправки=" + sendDay;
    }
}

