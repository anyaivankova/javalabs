package com;

public class Java extends Coffee {
    public Java(double weight, double price, int quality, String packageType, double size) {
        super(weight, price, quality, packageType, size);
    }

    @Override
    public String toString() {
        return "Java"+super.toString();
    }
}
