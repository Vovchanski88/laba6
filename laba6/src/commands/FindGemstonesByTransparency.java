package commands;

import gemstones.Gemstone;
import necklace.Necklace;

import java.util.Scanner;

public class FindGemstonesByTransparency implements Command{
    private Necklace necklace;

    public FindGemstonesByTransparency(Necklace necklace) {
        this.necklace = necklace;
    }
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Мінімальна прозорість (%): ");
        double min = scanner.nextDouble();
        System.out.println("Максимальна прозорість (%)");
        double max = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Камені з прозорістю в заданому діапазоні: ");
        for (Gemstone gemstone : necklace.findGemstonesByTransparency(min, max)) {
            System.out.println(gemstone);
        }
    }
}
