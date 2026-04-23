package ru.yandex.practicum.delivery;

public class StandartParcel extends Parcel {
    private static final int fixSum = 2;

    public StandartParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    public int weight() {
        return weight;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description +  " упакована");
    }

    @Override
    public int calculateDeliveryCost() {
        return weight * fixSum;
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
