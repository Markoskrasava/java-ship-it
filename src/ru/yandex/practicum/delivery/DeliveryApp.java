package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackingParcels = new ArrayList<>();

    private static final ParcelBox<StandartParcel> standartParcels = new ParcelBox<>(10);
    private static final ParcelBox<FragileParcel> fragileParcels = new ParcelBox<>(10);
    private static final ParcelBox<PerishableParcel> perishableParcels = new ParcelBox<>(10);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    trackParcels();
                    break;
                case 5:
                    gettingAllParcels();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Отследить посылку");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {


        while (true) {
            System.out.println("Какой тип посылки?");
            System.out.println("1. Стандартная посылка");
            System.out.println("2. Хрупкая посылка");
            System.out.println("3. Скоропортящаяся посылка");
            System.out.println("Нажмите любую другую цифру чтобы выйти");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Введите краткое описание: ");
                    String descriptionStandart = scanner.nextLine();
                    System.out.print("Введите вес: ");
                    int weightStandart = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите адрес доставки: ");
                    String deliveryAddressStandart = scanner.nextLine();
                    System.out.print("Введите день месяца, в который посылка будет отправлена: ");
                    int sendDayStandart = Integer.parseInt(scanner.nextLine());
                    StandartParcel standartParcel = new StandartParcel(descriptionStandart, weightStandart, deliveryAddressStandart, sendDayStandart);
                    allParcels.add(standartParcel);
                    standartParcels.addParcel(standartParcel);
                    break;
                case 2:
                    System.out.print("Введите краткое описание: ");
                    String descriptionFragile = scanner.nextLine();
                    System.out.print("Введите вес: ");
                    int weightFragile = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите адрес доставки: ");
                    String deliveryAddressFragile = scanner.nextLine();
                    System.out.print("Введите день месяца, в который посылка будет отправлена: ");
                    int sendDayFragile = Integer.parseInt(scanner.nextLine());
                    FragileParcel fragileParcel = new FragileParcel(descriptionFragile, weightFragile, deliveryAddressFragile, sendDayFragile);
                    allParcels.add(fragileParcel);
                    trackingParcels.add(fragileParcel);
                    fragileParcels.addParcel(fragileParcel);
                    break;
                case 3:
                    System.out.print("Введите краткое описание: ");
                    String descriptionPerishable = scanner.nextLine();
                    System.out.print("Введите вес: ");
                    int weightPerishable = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите адрес доставки: ");
                    String deliveryAddressPerishable = scanner.nextLine();
                    System.out.print("Введите день месяца, в который посылка будет отправлена: ");
                    int sendDayPerishable = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введите срок годности: ");
                    int timeToLivePerishable = Integer.parseInt(scanner.nextLine());
                    PerishableParcel perishableParcel = new PerishableParcel(descriptionPerishable, weightPerishable, deliveryAddressPerishable, sendDayPerishable, timeToLivePerishable);
                    allParcels.add(perishableParcel);
                    perishableParcels.addParcel(perishableParcel);
                    break;
                default:
                    System.out.println("До встречи");
                    return;
            }
        }

        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        if (!allParcels.isEmpty()) {
            for (Parcel parcel : allParcels) { // Посчитать общую стоимость всех доставок и вывести на экран
                parcel.packageItem();
                parcel.deliver();
            }
            allParcels.clear();
        } else {
            System.out.println("В списке нет доставок");
        }

    }

    private static void calculateCosts() {
        int totalCost = 0;
        if (!allParcels.isEmpty()) {
            for (Parcel parcel : allParcels) { // Посчитать общую стоимость всех доставок и вывести на экран
                int cost = parcel.calculateDeliveryCost();
                totalCost = totalCost + cost;
            }
            System.out.println("Общая стоимость всех доставок: " + totalCost);
        } else {
            System.out.println("В списке нет доставок");
        }
    }

    private static void trackParcels() {
        if (!trackingParcels.isEmpty()) {
            System.out.println("Введите новое местоположение");
            String newLocation = scanner.nextLine();
            for (Trackable trackingParcel : trackingParcels) {
                trackingParcel.reportStatus(newLocation);
            }
        }
    }

    private static void gettingAllParcels() {
        System.out.println("Какую коробку вы хотите посмотреть?");
        System.out.println("1. Коробку со стандартными посылками");
        System.out.println("2. Коробку с хрупкими посылками");
        System.out.println("3. Коробку со скоропортящимися посылками");
        int cmd = Integer.parseInt(scanner.nextLine());
        while (true) {
            switch (cmd) {
                case 1:
                    for (StandartParcel standartParcel : standartParcels.getAllParcels()) {
                        System.out.println(standartParcel);
                    }
                case 2:
                    for (FragileParcel fragileParcel : fragileParcels.getAllParcels()) {
                        System.out.println(fragileParcel);
                    }
                case 3:
                    for (PerishableParcel perishableParcel : perishableParcels.getAllParcels()) {
                        System.out.println(perishableParcel);
                    }
                default:
                    return;
            }
        }
    }

}

