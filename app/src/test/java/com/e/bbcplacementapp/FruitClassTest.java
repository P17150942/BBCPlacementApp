package com.e.bbcplacementapp;


import org.junit.Test;

import static org.junit.Assert.*;

public class FruitClassTest{

    @Test
    public void TestFruitConstructor(){
        Fruit fruit = new Fruit ("apple", 100, 200);

        assertEquals("Test the Type", "apple", fruit.getType());
        assertEquals("Test the Weight", 100, fruit.getPrice());
        assertEquals("Test the Price", 200, fruit.getWeight());
    }

    @Test
    public void TestSetGetType(){
        Fruit fruit = new Fruit ("apple", 100, 200);
        fruit.setType("Orange");
        assertEquals("Orange", fruit.getType());

    }

    @Test
    public void TestSetGetPrice(){
        Fruit fruit = new Fruit ("apple", 100, 200);
        fruit.setPrice(200);
        assertEquals(200, fruit.getPrice());
    }

    @Test
    public void TestSetGetWeight(){
        Fruit fruit = new Fruit ("apple", 100, 200);
        fruit.setWeight(350);
        assertEquals(350, fruit.getWeight());

    }

    public void TestToString(){
        Fruit fruit = new Fruit ("apple", 100, 200);

        assertEquals("Fruit: [Type: " + fruit.getType() +
                ", Price: " + fruit.getPrice() +
                ", Weight: " + fruit.getWeight() + "]"
                ,fruit.toString());
    }

    public void TestEquals() {
        Fruit fruit = new Fruit ("apple", 100, 200);
        Fruit fruit2 = new Fruit ("apple", 100, 200);
        Fruit fruit3 = new Fruit ("orange", 100, 200);

        assertEquals(true, fruit.equals(fruit2));
        assertEquals(false, fruit.equals(fruit3));

    }
}
