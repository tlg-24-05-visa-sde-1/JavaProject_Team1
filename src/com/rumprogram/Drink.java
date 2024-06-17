package com.rumprogram;

public class Drink implements Comparable<Drink> {

    // properties
    private final int id;
    private final String name;
    private final Double price;
    private final boolean nonAlcoholic;
    private final int rating;






    public Drink(int id, String name,Double price, boolean nonAlcoholic,int rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.nonAlcoholic = nonAlcoholic;
        this.rating = rating;
    }



    @Override
    public int compareTo(Drink otherDrink) {
     return Integer.compare(this.getRating(), otherDrink.getRating());

    }

    public String getName() {
      return name;
    }

    public Double getPrice() {
      return price;
    }

    public boolean isNonAlcoholic() {
      return nonAlcoholic;
    }

    public int getId() {
      return id;
    }

    public int getRating() {
        return rating;
    }
}
