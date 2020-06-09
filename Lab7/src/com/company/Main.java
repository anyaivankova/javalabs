package com.company;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {


        Coffee testItem = new Coffee(33, 33, 33, "Can", 33);
        CoffeeSet eSet = new CoffeeSet(testItem);
        for (int i= 0; i < 15; i++){
            eSet.add(new Coffee( (i+1)*5, (i+1)*10,(i+1)*15, "Beans",(i+1)*20));
        }
        Iterator iter = eSet.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        eSet.remove(testItem);
        System.out.println();

        for (Coffee coffee: eSet) {
            System.out.println(coffee);
        }

    }

}
