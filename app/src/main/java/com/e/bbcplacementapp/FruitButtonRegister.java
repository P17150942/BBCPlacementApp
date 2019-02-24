package com.e.bbcplacementapp;

import android.text.Layout;
import android.util.Log;
import android.widget.LinearLayout;
import android.text.Layout;

import java.util.ArrayList;

public class FruitButtonRegister {
    private ArrayList<FruitButton> register;
    private LinearLayout fruitButtonHolder;

    /**The custom constructor for a fruit button Register
     *
     * @param fruitButtonHolder the ui element that holds the group of buttons
     */
    public FruitButtonRegister(LinearLayout fruitButtonHolder){
        Log.d("WhatIsThisThing", "It works first");
        this.register = new ArrayList<FruitButton>();
        this.fruitButtonHolder = fruitButtonHolder;
        fruitButtonHolder.setOrientation(LinearLayout.VERTICAL);

    }

    /** Adds a given fruit button to this register
     *
     * @param fruitButton the fruit button to be added to this register
     */
    public void add(FruitButton fruitButton){
        this.register.add(fruitButton);
        fruitButtonHolder.addView(fruitButton.getButton());

    }

    /** Clears this register and clears the fruit button container
     *
     */
    public void clear(){
        register.clear();
        fruitButtonHolder.removeAllViews();
    }
}
