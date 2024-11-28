package commands;

import necklace.Necklace;

public class ShowTotalWeightAndPriceCommand implements Command {
    private Necklace necklace;

    public ShowTotalWeightAndPriceCommand (Necklace necklace) {
        this.necklace = necklace;
    }
    @Override
    public void execute() {
        System.out.printf("Загальна вага: %.2f карат, Загальна ціна: %.2f\n",
                          necklace.calculateTotalWeight(), necklace.calculateTotalPrice());
    }
}
