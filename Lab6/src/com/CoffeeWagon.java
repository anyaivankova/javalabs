package com;

import java.util.*;

public class CoffeeWagon {
    private double Capacity;
    private double freeSpace;
    private ArrayList<Coffee> coffeeCargo;

    public CoffeeWagon(double Capacity) {
        this.Capacity = Capacity;
        this.freeSpace = Capacity;
        this.coffeeCargo = new ArrayList<>();
    }


    private void fillByPrice(double price, Coffee[] coffeeList) {
       double space = currentFreeSpace();
       double pricePerSize = price/space;

    }

    public void fillByPriceFromCoffeeMenu(double totalCost, Coffee[] coffeeMenu) {
        freeSpace = currentFreeSpace();
        List<Coffee> coffeeList = Arrays.asList(coffeeMenu);
        double tempPrice;
        double tempSize;

        if(coffeeMenu.length == 0){
            System.err.println("Wrong input! Empty coffee list");
        }else {
            int fullLoadAmount = countFullLoads(totalCost, freeSpace, coffeeMenu);
            for (int i = 0; i < fullLoadAmount; i++){
                coffeeCargo.addAll(coffeeList);
            }
            freeSpace = currentFreeSpace();
            totalCost = updateTotalCost(totalCost);
            System.err.println("\n"+totalCost);
            for(Coffee coffee: coffeeMenu){
                tempPrice = coffee.getPrice();
                tempSize = coffee.getSize()+coffee.getPackageSize();
                if (tempPrice <= totalCost && tempSize <= freeSpace){
                    coffeeCargo.add(coffee);
                    totalCost -= tempPrice;
                    freeSpace -= tempSize;
                }
            }
        }
        System.err.println("\n"+totalCost);
    }

    private double updateTotalCost(double totalCost) {
        double sum = 0.0;
        for (Coffee coffee: coffeeCargo) {
            sum += coffee.getPrice();
        }
        return (totalCost-sum);
    }

    private double currentFreeSpace() {
        double currentFreeSpace = Capacity;
        for (Coffee coffee: coffeeCargo) {
            currentFreeSpace -= (coffee.getSize() + coffee.getPackageSize());
        }
        if (currentFreeSpace < 0){
            return 0.0;
        }
        return currentFreeSpace;
    }


    private int countFullLoads(double price, double freeSpace, Coffee[] coffeeMenu) {
        double loadPrice = 0;
        double loadSize = 0;
        for (Coffee coffee: coffeeMenu) {
            loadPrice += coffee.getPrice();
            loadSize += coffee.getSize() + coffee.getPackageSize();
        }
        int fullLoadAmountByPrice = (int)Math.floor(price/loadPrice);
        int fullLoadAmountBySize = (int)Math.floor(freeSpace/loadSize);
        if (fullLoadAmountByPrice < fullLoadAmountBySize){
            return fullLoadAmountByPrice;
        }
        return fullLoadAmountBySize;
    }

    public ArrayList<Coffee> findByQuality(int min, int max) {
        ArrayList<Coffee> resultList = new ArrayList<>();
        for (Coffee coffee: coffeeCargo) {
            int quality = coffee.getQuality();
            if (min <= quality && quality <= max){
                resultList.add(coffee);
            }
        }
        return resultList;
    }

    public void sortByPricePerWeight() {
        Collections.sort(coffeeCargo, new byPricePerWeight());
    }

    @Override
    public String toString() {
        String output = "CoffeeWagon{"+
                "freeSpace=" + freeSpace +
                ", coffeeCargo:\n";
        for(Coffee coffee: coffeeCargo){
            output += coffee.toString() + "\n";
        }
        return output;
    }
}
