package main;

import commands.*;
import necklace.Necklace;
import menu.Menu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Necklace necklace = new Necklace();
        Menu menu = new Menu();

        menu.addCommand("1", new CreateNecklaceAndAddGemstoneCommand(scanner, necklace));
        menu.addCommand("2", new ShowNecklaceCommand(necklace));
        menu.addCommand("3", new ShowTotalWeightAndPriceCommand(necklace));
        menu.addCommand("4", new SortByTransperency(necklace));
        menu.addCommand("5", new FindGemstonesByTransparency(necklace));

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Створити намисто");
            System.out.println("2. Показати камені в намисті");
            System.out.println("3. Загальна вага і ціна намиста");
            System.out.println("4. Сортувати камені в намисті за цінністю (прозорістю)");
            System.out.println("5. Знайти камені за прозорістю у намисті");
            System.out.println("0. Вихід");
            System.out.print("Виберіть опцію: ");

            String choice = scanner.nextLine();
            if (choice.equals("0")) {
                System.out.println("Вихід з програми.");
                break;
            }
            menu.executeCommand(choice);
        }
        scanner.close();
    }
}
