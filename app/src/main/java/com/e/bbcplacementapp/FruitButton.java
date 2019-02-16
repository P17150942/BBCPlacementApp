package com.e.bbcplacementapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class FruitButton {
    private Fruit fruit;
    private Button button;


    public  FruitButton(){
        this.fruit = new Fruit();
        this.button = new Button(new MainActivity());

    }

    public FruitButton(Fruit fruit, Button button){
        this.fruit = fruit;
        this.button = button;

    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(new FruitPage().getIntent());
            }
        });
    }

    private void changeActivity( Intent intent){
        intent.putExtra("fruit", this.fruit);
        button.getContext().startActivity(intent);



    }
    public Context getContext(){
        return button.getContext();
    }




}
