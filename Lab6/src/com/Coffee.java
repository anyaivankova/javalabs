package com;

public class Coffee {
    private double pricePerWeight;
    private double weight;
    private double price;
    private double size;
    private int quality;
    private String packageType;
    private double packageSize;


    public Coffee(double weight, double price, int quality, String packageType, double size) {
        this.weight = weight;
        this.price = price;
        this.size = size;
        this.quality = quality;
        this.packageType = packageType;
        this.packageSize = setPackageSize(packageType);
        this.pricePerWeight = price/weight;
    }

    private double setPackageSize(String packageType) {
        switch (packageType){
            case "Can":
                return 12.0;
            case "Bag":
                return 4.2;
            case "Beans":
                return 0.2;
            case "Loose":
                return 0.1;
        }
        System.err.println("Wrong package type parameter! Please check input data and reset package type!");
        return 0.0;
    }

    public double getWeight() {
        return weight;
    }

    public void resetPackageType(String packageType){
        this.packageType = packageType;
        this.packageSize = setPackageSize(packageType);
    }

    public double getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }

    public int getQuality() {
        return quality;
    }

    public double getPricePerWeight() {
        return pricePerWeight;
    }

    public double getPackageSize() {
        return packageSize;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "pricePerWeight=" + pricePerWeight +
                ", weight=" + weight +
                ", price=" + price +
                ", size=" + size +
                ", quality=" + quality +
                ", packageType='" + packageType + '\'' +
                ", packageSize=" + packageSize +
                '}';
    }
}
