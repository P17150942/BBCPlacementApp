package com.e.bbcplacementapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class FruitButton {
    private Fruit fruit;
    private Button button;
    private Context context;

    public  FruitButton(){
        this.fruit = new Fruit();
        this.button = new Button(new MainActivity());
        this.context = button.getContext();
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(new Intent(context, FruitPage.class));
            }
        });

    }

    public FruitButton(Fruit fruit, Button button){
        this.fruit = fruit;
        this.button = button;
        this.context = button.getContext();
        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                changeActivity(new Intent(context, FruitPage.class));
            }
        });

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
                changeActivity(new Intent(context, FruitPage.class));
            }
        });
    }

    public void changeActivity( Intent intent){
        intent.putExtra("fruit", this.fruit);
       context.startActivity(intent);




    }
    public Context getContext(){
        return context;
    }




}
