package commands;

import necklace.Necklace;

public class ShowNecklaceCommand implements Command {
    private Necklace necklace;

    public ShowNecklaceCommand(Necklace necklace) {
        this.necklace = necklace;
    }

    @Override
    public void execute() {
        System.out.println(necklace.toString());
    }
}
