package com.e.bbcplacementapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class FruitButton {
    private Fruit fruit;
    private Button button;

    public FruitButton(Fruit fruit, Button button){
        this.fruit = fruit;
        this.button = button;

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FruitPage.class);

                intent.putExtra("fruit", getFruit());
                getContext().startActivity(intent);
            }
        });

    }

    public Fruit getFruit() {
        return this.fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;

    }

    public Context getContext(){
        return button.getContext();
    }




}
