package com;

public class Arabica extends Coffee {
    public Arabica(double weight, double price, int quality, String packageType, double size) {
        super(weight, price, quality, packageType, size);
    }

    @Override
    public String toString() {
        return "Arabica"+super.toString();
    }
}
