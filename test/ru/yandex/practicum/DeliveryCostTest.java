package ru.yandex.practicum;

import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandartParcel;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DeliveryCostTest {

    @Test
    public void shouldBePositiveForStandartParcelCalculateDeliveryCost() {
        StandartParcel testStandartParcel = new StandartParcel("Компьютер", 10, "улица Компьютерная 10к1", 15);
        assertNotNull(testStandartParcel.weight());
        assertEquals(20, testStandartParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBePositiveForFragileParcelCalculateDeliveryCost() {
        FragileParcel testFragileParcel = new FragileParcel("Ваза", 3, "бульвар Вазовый 16", 20);
        assertNotNull(testFragileParcel.weight());
        assertEquals(12, testFragileParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBePositiveForPerishableParcelCalculateDeliveryCost() {
        PerishableParcel testPerishableParcel = new PerishableParcel("Бананы", 20, "бульвар Бананов 72", 25, 7);
        assertNotNull(testPerishableParcel.weight());
        assertEquals(60, testPerishableParcel.calculateDeliveryCost());
    }

    @Test
    public void shouldBePositiveForMethodIsExpired() {
        PerishableParcel testPerishableParcel = new PerishableParcel("Бананы", 20, "бульвар Бананов 72", 25, 7);
        assertTrue(testPerishableParcel.isExpired(33));
    }

    @Test
    public void shouldBeNegativeForMethodIsExpired() {
        PerishableParcel testPerishableParcel = new PerishableParcel("Бананы", 20, "бульвар Бананов 72", 25, 7);
        assertFalse(testPerishableParcel.isExpired(32));
    }

    @Test
    public void shouldOutOFArray() {
        int currentWeight = 0;
        ParcelBox<StandartParcel> Box = new ParcelBox<>(10);
        StandartParcel testStandartParcel = new StandartParcel("Компьютер", 9, "улица Компьютерная 10к1", 15);
        if (Box.getMaxWeight() > (testStandartParcel.weight() + currentWeight)){
            Box.addParcel(testStandartParcel);
            currentWeight += testStandartParcel.weight();
        } else {
            System.out.println("Нельзя добавить посылку");
        }
        assertTrue(Box.getMaxWeight() > currentWeight);
        StandartParcel testStandartParcel1 = new StandartParcel("Компьютер", 9, "улица Компьютерная 10к1", 15);
        if (Box.getMaxWeight() > (testStandartParcel1.weight() + currentWeight)){
            Box.addParcel(testStandartParcel);
            currentWeight += testStandartParcel.weight();
        } else {
            System.out.println("Нельзя добавить посылку");
        }
        assertTrue(Box.getMaxWeight() > currentWeight);
    }

    @Test
    public void shouldBeEqualStandartParcel() {
        StandartParcel testStandartParcel1 = new StandartParcel("Компьютер", 4, "улица Компьютерная 10к1", 15);
        StandartParcel testStandartParcel2 = new StandartParcel("Компьютер", 4, "улица Компьютерная 10к1", 15);
        if (testStandartParcel1.equals(testStandartParcel2)) {
            System.out.println("В классе StandartParcel equals работает корректно");
        }
        assertTrue(testStandartParcel1.equals(testStandartParcel2));
    }

    @Test
    public void shouldBeEqualFragileParcel() {
        FragileParcel testFragileParcel1 = new FragileParcel("Компьютер", 4, "улица Компьютерная 10к1", 15);
        FragileParcel testFragileParcel2 = new FragileParcel("Компьютер", 4, "улица Компьютерная 10к1", 15);
        if (testFragileParcel1.equals(testFragileParcel2)) {
            System.out.println("В классе StandartParcel equals работает корректно");
        }
        assertTrue(testFragileParcel1.equals(testFragileParcel2));
    }

    @Test
    public void shouldBeEqualPerishableParcel() {
        PerishableParcel testPerishableParcel1 = new PerishableParcel("Компьютер", 4, "улица Компьютерная 10к1", 15, 9);
        PerishableParcel testPerishableParcel2 = new PerishableParcel("Компьютер", 4, "улица Компьютерная 10к1", 15, 9);
        if (testPerishableParcel1.equals(testPerishableParcel2)) {
            System.out.println("В классе PerishableParcel equals работает корректно");
        }
        assertTrue(testPerishableParcel1.equals(testPerishableParcel2));
    }

}
