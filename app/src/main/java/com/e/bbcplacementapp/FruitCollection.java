package com.e.bbcplacementapp;

import java.util.ArrayList;
import java.util.Iterator;

public class FruitCollection implements Iterable<Fruit>{
    private ArrayList<Fruit> fruitList;

    /** The default fruit collection constructor
     *
     */
    public FruitCollection(){
        fruitList = new ArrayList<Fruit>();
    }

    /** Adds a given fruit to this collection
     *
     * @param fruit the fruit to be added to the fruit collection
     */
    public void add(Fruit fruit){
        fruitList.add(fruit);
    }

    /** Removes a fruit from this collection, by a given index
     *
     * @param i the index of the fruit to be removed from te fruit collection
     */
    public void remove(int i){
        fruitList.remove(i);
    }

    /** Removes a fruit from this coleection, by a given fruit
     *
     * @param fruit the fruit to be removed from this collection
     */
    public void remove (Fruit fruit){
        fruitList.remove(fruit);
    }

    /** Returns the iterator of this collection
     *
     * @return the iterator of fruitList
     */
    public Iterator<Fruit> iterator(){
        return fruitList.iterator();

    }


    /** Removes all the fruit in this collection
     *
     */
    public void clear(){
        fruitList.clear();
    }

    /** Returns the length of this collection
     *
     * @return the length of this collection
     */
    public int length(){
        return fruitList.size();
    }

    /** Returns a fruit equal to the given fruit.
     * Returns null if one is not found
     *
     * @param fruit the fruit to find
     * @return the first fruit equal to the given fruit
     */
    public Fruit getFruit(Fruit fruit){
        for (Fruit f : this){
            if (f.equals(fruit)){
                return f;
            }
        }
        return null;
    }

    /** Returns a fruit in this collection by a given index.
     *
     * @param index the index of the fruit to get
     * @return the fruit retrieved by the index
     */
    public Fruit getFruit(int index){
        return fruitList.get(index);
    }

}
