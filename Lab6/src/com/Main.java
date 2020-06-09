package com;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int coffeeNum = 4;


        Coffee javaCans = new Java(20.0, 164.50, 30, "Can",22.0);
        Coffee looseArabica = new Arabica(30.0, 204.50, 30, "Loose",28.0);
        Coffee mochaBeans = new Mocha(35.0, 84.50, 30, "Beans",35.0);
        Coffee robustaBags = new Robusta(32.0, 54.50, 30, "Bag",43.0);
        Coffee libericaCans = new Liberica(15.0, 184.50, 45, "WrongInput!",32.0);
        System.out.println(libericaCans);
        libericaCans.resetPackageType("Can");
        System.out.println("After reset:");
        System.out.println(libericaCans+"\n");

        Coffee[] coffeeList = new Coffee[]{javaCans, looseArabica, mochaBeans, robustaBags, libericaCans};

        CoffeeWagon wagonOne = new CoffeeWagon(3000);


        wagonOne.fillByPriceFromCoffeeMenu(675, coffeeList);
        ArrayList<Coffee> findList = wagonOne.findByQuality(28, 48);
        for (Coffee findCoffee: findList) {
            System.out.println(findCoffee);
        }

        System.out.println();

        System.out.println(wagonOne);; //Вывод несортированого масива
        System.out.println();
        //Arrays.sort(wagonOne, new byPricePerWeight());//Сортируем
        wagonOne.sortByPricePerWeight();
        System.out.println(wagonOne);//Вывод после сортировки




    }
}
