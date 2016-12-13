package com.Daniel.dog;

/**
 * Created by Daniel on 12/13/16.
 */
public class Dog {
    private String name;
    private int numFleas;
    private DogType dogType;

    public String getName() {
        return name;
    }

    public int getNumFleas() {
        return numFleas;
    }

    public DogType getDogType() {
        return dogType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumFleas(int numFleas) {
        this.numFleas = numFleas;
    }

    public void setDogType(DogType dogType) {
        this.dogType = dogType;
    }

    public Dog(String name) {
        this.name = name;
        this.dogType = DogType.GERMAN_SHEPHERD;
        this.numFleas = 0;
    }

    public void changeFleas(int fleaCount) throws Exception {
        int totalFleas = fleaCount + numFleas;

        if (totalFleas>0 && totalFleas<5000){
        //if ((numFleas+=fleaCount) > 0 && (numFleas +=fleaCount) < 5000){
            this.numFleas = numFleas + fleaCount;
        } else {
            throw new Exception("Too many/Not enough fleas!");
        }

    }

}
