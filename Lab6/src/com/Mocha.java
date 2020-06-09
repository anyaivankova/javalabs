package com;

public class Mocha extends Coffee {
    public Mocha(double weight, double price, int quality, String packageType, double size) {
        super(weight, price, quality, packageType, size);
    }

    @Override
    public String toString() {
        return "Mocha"+super.toString();
    }
}
