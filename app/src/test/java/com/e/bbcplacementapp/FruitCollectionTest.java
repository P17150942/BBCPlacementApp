package com.e.bbcplacementapp;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class FruitCollectionTest {

    @Test
    public void TestDefaultConstructor(){
        FruitCollection fc = new FruitCollection();

        assertEquals( 0, fc.length());
    }



    @Test
    public void TestAddFind(){
        FruitCollection fc = new FruitCollection();
        fc.add(new Fruit("apple",100,100));
        assertEquals(new Fruit("apple",100,100), fc.find(0));



    }

    @Test
    public void TestAddRemove(){
        FruitCollection fc = new FruitCollection();
        fc.add(new Fruit("apple",100,10));
        fc.remove(0);

        FruitCollection fc2 = new FruitCollection();
        Fruit f = new Fruit("apple",100,10)
        fc.add(new Fruit("apple",100,10));
        fc2.remove(f);

        assertTrue( fc.length() == 0);
        assertTrue(fc2.length()==0);



    }

    @Test
    public void TestIteratorImplementation(){
        FruitCollection fc = new FruitCollection();
        for (Fruit f : fc){
            f.getClass();
        }


    }



    @Test
    public void TestClear(){
        FruitCollection fc = new FruitCollection();
        fc.add(new Fruit("apple",100,10));
        fc.add(new Fruit("orange",300,10));
        fc.add(new Fruit("apple",100,100));
        fc.add(new Fruit("apple",100,10));

        fc.clear();
        assertTrue(fc.length() == 0);
    }

    @Test
    public void TestLength(){
        FruitCollection fc = new FruitCollection();
        fc.add(new Fruit("apple",100,10));
        fc.add(new Fruit("orange",300,10));
        fc.add(new Fruit("apple",100,100));
        fc.add(new Fruit("apple",100,10));

        assertTrue(fc.length() == 4);

    }

    @Test
    public void TestGetFruit(){
        FruitCollection fc = new FruitCollection();
        fc.add(new Fruit("apple",100,10));
        fc.add(new Fruit("orange",300,10));
        fc.add(new Fruit("apple",100,100));
        fc.add(new Fruit("apple",100,10));

        Fruit f = fc.getFruit(new Fruit("orange", 300, 10));

        FruitCollection fc2 = new FruitCollection();
        fc2.add(new Fruit("apple",100,10));
        fc2.add(new Fruit("orange",300,10));
        fc2.add(new Fruit("apple",100,100));
        fc2.add(new Fruit("apple",100,10));

        Fruit f2 = fc2.getFruit(1);

        assertTrue(fc2.getFruit(2).equals(new Fruit("orange",300,10)));
        assertTrue(fc.getFruit(new Fruit("orange",300,10)).equals(new Fruit("orange",300,10)));

    }
}
