package gemstones;

import java.io.Serializable;

public abstract class Gemstone implements Serializable {
    private String name;
    private double weight;
    private double price;
    private double transparency;

    public Gemstone(String name, double weight, double price, double transparency) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.transparency = transparency;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public double getTransparency() {
        return transparency;
    }

    @Override
    public String toString() {
        return String.format("Ім'я: %s, Вага: %.2f, Ціна: %.2f, Прозорість: %.2f%%",
                name, weight, price, transparency);
    }
}