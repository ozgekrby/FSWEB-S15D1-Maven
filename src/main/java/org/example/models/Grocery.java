package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static final ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n0: Çıkış");
            System.out.println("1: Ürün Ekle");
            System.out.println("2: Ürün Çıkar");
            System.out.print("Seçiminiz: ");

            String input = scanner.nextLine();
            switch (input) {
                case "0" -> running = false;
                case "1" -> {
                    System.out.print("Eklenmesini istediğiniz elemanları giriniz: ");
                    addItems(scanner.nextLine());
                }
                case "2" -> {
                    System.out.print("Çıkarılmasını istediğiniz elemanları giriniz: ");
                    removeItems(scanner.nextLine());
                }
                default -> System.out.println("Geçersiz seçim!");
            }
            printSorted();
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim().toLowerCase();
            if (!checkItemIsInList(trimmedItem)) {
                groceryList.add(trimmedItem);
            }
        }
        sortList();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim().toLowerCase();
            groceryList.remove(trimmedItem);
        }
        sortList();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.toLowerCase());
    }

    public static void printSorted() {
        sortList();
        System.out.println("\nGüncel Liste:");
        groceryList.forEach(item -> System.out.println("- " + item));
    }

    private static void sortList() {
        Collections.sort(groceryList);
    }
}
