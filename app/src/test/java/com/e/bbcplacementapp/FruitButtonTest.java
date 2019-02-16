package com.e.bbcplacementapp;

import android.widget.Button;

import org.junit.Test;
import android.content.Context;
import android.content.Intent;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class FruitButtonTest {


    @Test
    public void TestDefaultConstructor(){

        FruitButton fb = new FruitButton();
        assertTrue(fb.getButton().equals(new Button(new FruitPage())));
        assertTrue(fb.getFruit().equals(new Fruit()));
    }

    @Test
    public void TestConstructor(){
        Button button = new Button(new MainActivity());
        FruitButton fb = new FruitButton(new Fruit("apple", 100,10),button);


        assertTrue(fb.getButton().equals(button));
        assertTrue(fb.getFruit().equals(new Fruit("apple", 100,10)));

    }

    @Test
    public void TestSetGetFruit() {
        Button button = new Button(new MainActivity());
        Fruit fruit = new Fruit("apple", 100, 10);
        FruitButton fb = new FruitButton(fruit, button);

        fb.setFruit(new Fruit("orange", 100, 200));
        assertTrue(fb.getFruit().equals(new Fruit("apple", 100, 10)));
    }

    @Test
    public void TestSetGetButton(){
        Button button = new Button(new MainActivity());
        Fruit fruit = new Fruit("apple", 100, 10);
        FruitButton fb = new FruitButton(fruit, button);

        fb.setButton(new Button(new FruitPage()));
        assertTrue(fb.getButton().equals(new Button(new FruitPage())));
    }

    @Test
    public void TestGetContext(){
        Button button = new Button(new MainActivity());
        Fruit fruit = new Fruit("apple", 100, 10);
        FruitButton fb = new FruitButton(fruit, button);

        assertTrue(button.getContext().equals(fb.getContext()));


    }
}
