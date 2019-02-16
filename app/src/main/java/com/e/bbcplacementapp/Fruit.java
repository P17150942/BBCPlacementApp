package com.e.bbcplacementapp;

public class Fruit {
    private String type;
    private int price;
    private int weight;

    public Fruit(){
        this.type = "";
        this.price = 0;
        this.weight = 0;
    }

    public Fruit (String type, int price, int weight){
        this.type = type;
        this.price = price;
        this.weight = weight;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public String getType(){
        return this.type;
    }

    public int getPrice(){
        return this.price;
    }

    public int getWeight(){
        return this.weight;
    }

    @Override
    public String toString(){
        return "Fruit: [Type: " + this.type +
                ", Price: " + this.price +
                ", Weight: " + this.weight + "]";
    }

    @Override
    public boolean equals(Object obj){
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }
        Fruit other = (Fruit) obj;
        return this.type.equals(other.type) &&
                this.price == other.price &&
                this.weight == other.weight;
    }
}
