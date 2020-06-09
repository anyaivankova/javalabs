package com;

public class Liberica extends Coffee {
    public Liberica(double weight, double price, int quality, String packageType, double size) {
        super(weight, price, quality, packageType, size);
    }
    @Override
    public String toString() {
        return "Liberica"+super.toString();
    }
}
