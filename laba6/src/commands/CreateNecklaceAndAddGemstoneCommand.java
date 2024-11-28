package commands;

import gemstones.*;
import necklace.Necklace;
import java.util.Scanner;

public class CreateNecklaceAndAddGemstoneCommand implements Command {
    private Necklace necklace;
    private Scanner scanner;

    public CreateNecklaceAndAddGemstoneCommand(Scanner scanner, Necklace necklace) {
        this.scanner = scanner;
        this.necklace = necklace;
    }

    @Override
    public void execute() {
        System.out.println("Намисто створено!");

        while (true) {
            System.out.print("Тип каменя (1 - Дорогоцінний, 2 - Напівкоштовний або -1 для виходу): ");
            int gemType = scanner.nextInt();
            if (gemType == -1) {
                break;
            }
            scanner.nextLine();  // Очищаємо буфер

            Gemstone gemstone = createGemstone(gemType);
            if (gemstone != null) {
                necklace.addGemstone(gemstone);
                System.out.println("Камінь додано до намиста.");
            } else {
                System.out.println("Невірний тип каменя.");
            }
        }
    }

    private Gemstone createGemstone(int type) {
        System.out.println("Виберіть камінь:");
        if (type == 1) {
            // Дорогоцінні камені
            System.out.println("1. Алмаз");
            System.out.println("2. Рубін");
            System.out.println("3. Сапфір");
        } else if (type == 2) {
            // Напівкоштовні камені
            System.out.println("1. Бірюза");
            System.out.println("2. Опал");
            System.out.println("3. Аметист");
        }

        int gemChoice = scanner.nextInt();
        scanner.nextLine();  // Очищаємо буфер

        String name = getGemstoneName(type, gemChoice);
        if (name == null) {
            System.out.println("Невірний вибір.");
            return null;
        }

        System.out.print("Вага (карати): ");
        double weight = scanner.nextDouble();
        System.out.print("Ціна: ");
        double price = scanner.nextDouble();
        System.out.print("Прозорість (%): ");
        double transparency = scanner.nextDouble();
        scanner.nextLine();  // Очищаємо буфер

        if (type == 1) {
            return new PreciousGemstone(name, weight, price, transparency);
        } else {
            return new SemiPreciousGemstone(name, weight, price, transparency);
        }
    }

    private String getGemstoneName(int type, int gemChoice) {
        switch (type) {
            case 1:
                switch (gemChoice) {
                    case 1: return "Алмаз";
                    case 2: return "Рубін";
                    case 3: return "Сапфір";
                    default: return null;
                }
            case 2:
                switch (gemChoice) {
                    case 1: return "Бірюза";
                    case 2: return "Опал";
                    case 3: return "Аметист";
                    default: return null;
                }
            default:
                return null;
        }
    }
}
