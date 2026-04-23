package ru.yandex.practicum.delivery;

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
    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    @Override
    public int calculateDeliveryCost() {
        return weight * fixSum;
    }

    public boolean isExpired(int currentDay) {
         if ((sendDay + timeToLive) >= currentDay) {
             return false;
         } else {
             return true;
         }

    }

    @Override
    public String toString() {
        return "[Описание='" + description + '\'' +
                ", Вес=" + weight +
                ", Адрес доставки='" + deliveryAddress + '\'' +
                ", День отправки=" + sendDay + '\'' +
                ", Срок годности=" + timeToLive +
                "]";
    }
}
