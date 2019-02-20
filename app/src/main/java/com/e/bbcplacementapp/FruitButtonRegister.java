package com.e.bbcplacementapp;

import android.text.Layout;
import android.util.Log;
import android.widget.LinearLayout;
import android.text.Layout;

import java.util.ArrayList;

public class FruitButtonRegister {
    private ArrayList<FruitButton> register;
    private LinearLayout fruitButtonHolder;

    public FruitButtonRegister(LinearLayout fruitButtonHolder){
        Log.d("WhatIsThisThing", "It works first");
        this.register = new ArrayList<FruitButton>();
        this.fruitButtonHolder = fruitButtonHolder;
        fruitButtonHolder.setOrientation(LinearLayout.VERTICAL);

    }

    public void add(FruitButton fruitButton){
        this.register.add(fruitButton);
        fruitButtonHolder.addView(fruitButton.getButton());

    }

    public void clear(){
        register.clear();
        fruitButtonHolder.removeAllViews();
    }
}
