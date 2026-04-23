package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable{
    private static final int fixSum = 4;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    public int weight() {
        return weight;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
        System.out.println("Посылка " +  description + " упакована");
    }

    @Override
    public int calculateDeliveryCost() {
        return weight * fixSum;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }

    @Override
    public String toString() {
        return "[Описание='" + description + '\'' +
                ", Вес=" + weight +
                ", Адрес доставки='" + deliveryAddress + '\'' +
                ", День отправки=" + sendDay +
                "]";
    }
}
