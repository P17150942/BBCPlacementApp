package com.e.bbcplacementapp;

import android.os.Parcelable;
import android.util.Log;
import android.os.Parcel;


import org.json.JSONException;
import org.json.JSONObject;

public class Fruit implements Parcelable {
    private String type;
    private int price;
    private int weight;


    public static Parcelable.Creator<Fruit> CREATOR
            = new Parcelable.Creator<Fruit>(){
        @Override
        public Fruit createFromParcel(Parcel source) {
            return new Fruit(source);
        }

        @Override
        public Fruit[] newArray(int size) {
            return new Fruit[size];
        }
    };

    private Fruit (Parcel in){
        type = in.readString();
        price = in.readInt();
        weight = in.readInt();
    }


    public Fruit(){
        this.type = "";
        this.price = 0;
        this.weight = 0;
    }

    /** Fruit Constructor from JSON file
     *
     * @param jsonObj The params of this in the form of {"type":"s", "price":d, weight:d}
     * @throws JSONException Throws exception when JSon object cannot be made into an instance of fruit
     */
    public Fruit(JSONObject jsonObj) throws JSONException{
        this.type = jsonObj.getString("type");
        this.price = jsonObj.getInt("price");
        this.weight = jsonObj.getInt("weight");
    }

    /** Custom Fruit Constructor
     *
     * @param type the type of fruit that to be created
     * @param price the price of the fruit to be created
     * @param weight the weight of the fruit to be created
     */
    public Fruit (String type, int price, int weight){
        this.type = type;
        this.price = price;
        this.weight = weight;
    }

    /** Changes the type of this frut
     *
     * @param type the type to be set of this object
     */
    public void setType(String type){
        this.type = type;
    }

    /** Changes the price of this fruit
     *
     * @param price the price to be set of this object
     */
    public void setPrice(int price){
        this.price = price;
    }

    /** Changes the weight of this fruit.
     *
     * @param weight the weight of this object to be set
     */
    public void setWeight(int weight){
        this.weight = weight;
    }

    /** Returns the type of this fruit.
     *
     * @return the type of this fruit
     */
    public String getType(){
        return this.type;
    }

    /** Returns the price of this fruit.
     *
     * @return the price of this fruit
     */
    public int getPrice(){
        return this.price;
    }

    /** Returns the weight of this fruit.
     *
     * @return the weight of this fruit
     */
    public int getWeight(){
        return this.weight;
    }

    /** Returns a textual representation of this fruit.
     *
     * @return the textual representation of this fruit
     */
    @Override
    public String toString(){
        return "Fruit: [Type: " + this.type +
                ", Price: " + this.price +
                ", Weight: " + this.weight + "]";
    }

    /** Compares this fruit and another object.
     * Returns true if the types match and the feilds are equal
     * to each otther. False otherwise
     *
     * @param obj The object to be compared
     * @return weather the object is equal
     */
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


    /** Allows this object to be used as a parcable
     *
     * @return the description of the contents
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /** Allows this object to be used as a parcable
     *
     * @param dest the destination of this fruit as a parceble
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeInt(this.price);
        dest.writeInt(this.weight);
    }



}
