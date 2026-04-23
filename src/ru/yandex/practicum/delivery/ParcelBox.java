package ru.yandex.practicum.delivery;

import java.util.ArrayList;

public class ParcelBox <T extends Parcel>{
    ArrayList<T> parcels;
    private int maxWeight;
    private int currentWeight;

    public ParcelBox(int maxWeight) {
        this.parcels = new ArrayList<>();
        this.maxWeight = maxWeight;
        this.currentWeight = 0;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void addParcel(T parcel) {
        if (maxWeight > currentWeight) {
            parcels.add(parcel);
            currentWeight += parcel.weight;
            System.out.println("Посылка " + parcel + " добавлена в коробку");
        } else {
            System.out.println("Нельзя добавить посылку чтобы не было перевеса");
        }
    }

    public ArrayList<T> getAllParcels() {
        return parcels;
    }


}
