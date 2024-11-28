package commands;

import gemstones.Gemstone;
import necklace.Necklace;

import java.util.List;

public class SortByTransperency implements Command{
    private Necklace necklace;

    public SortByTransperency(Necklace necklace) {
        this.necklace = necklace;
    }
    @Override
    public void execute() {
        List<Gemstone> sortedList = necklace.getSortedByTransparency();
        System.out.println("Камені в намисті відсортовані за цінністю.");
        for (Gemstone gemstone : sortedList) {
            System.out.println(gemstone);
        }
    }
}
