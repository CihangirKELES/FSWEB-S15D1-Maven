package org.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        startGrocery();
    }
    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nSeçenekler:");
            System.out.println("0 - Uygulamayı durdur");
            System.out.println("1 - Ürün ekle");
            System.out.println("2 - Ürün çıkar");
            System.out.print("Seçiminizi yapınız: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("Uygulama sonlandırılıyor.");
                    isRunning = false;
                    break;
                case 1:
                    System.out.print("Eklemek istediğiniz ürünleri girin (tekli ya da virgüllü liste): ");
                    String itemsToAdd = scanner.nextLine();
                    addItems(itemsToAdd);
                    break;
                case 2:
                    System.out.print("Çıkarmak istediğiniz ürünleri girin (tekli ya da virgüllü liste): ");
                    String itemsToRemove = scanner.nextLine();
                    removeItems(itemsToRemove);
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen 0, 1 veya 2 seçiniz.");
            }
        }
        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",\\s*");
        for (String item : items) {
            if (!checkItemIsInList(item)) {
                groceryList.add(item.trim());
            } else {
                System.out.println(item + " zaten listede mevcut.");
            }
        }
        sortAndPrintList();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",\\s*");
        for (String item : items) {
            if (checkItemIsInList(item)) {
                groceryList.remove(item.trim());
            } else {
                System.out.println(item + " listede mevcut değil.");
            }
        }
        sortAndPrintList();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product.trim());
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("\nSıralı Liste: " + groceryList);
    }

    private static void sortAndPrintList() {
        Collections.sort(groceryList);
        System.out.println("\nGüncel Liste: " + groceryList);
    }
}
