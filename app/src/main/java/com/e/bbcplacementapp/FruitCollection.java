package com.e.bbcplacementapp;

import java.util.ArrayList;
import java.util.Iterator;

public class FruitCollection implements Iterable<Fruit>{
    private ArrayList<Fruit> fruitList;

    public FruitCollection(){
        fruitList = new ArrayList<Fruit>();
    }

    public void add(Fruit fruit){
        fruitList.add(fruit);
    }

    public void remove(int i){
        fruitList.remove(i);
    }

    public void remove (Fruit fruit){
        fruitList.remove(fruit);
    }

    public Iterator<Fruit> iterator(){
        return fruitList.iterator();

    }


    public void clear(){
        fruitList.clear();
    }

    public int length(){
        return fruitList.size();
    }

    public Fruit getFruit(Fruit fruit){
        for (Fruit f : this){
            if (f.equals(fruit)){
                return f;
            }
        }
        return null;
    }

    public Fruit getFruit(int index){
        return fruitList.get(index);
    }




}
