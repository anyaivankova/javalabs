package com;

public class Robusta extends Coffee {
    public Robusta(double weight, double price, int quality, String packageType, double size) {
        super(weight, price, quality, packageType, size);
    }

    @Override
    public String toString() {
        return "Robusta"+super.toString();
    }
}
