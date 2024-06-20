package com.rumprogram;

public class Drink implements Comparable<Drink> {

    // properties
    private  int id;
    private final String name;
    private final double price;
    private boolean nonAlcoholic;
    private final double rating;

    public Drink(String name, Double price, Double rating) {
        this.name =name;
        this.price = price;
        this.rating =rating;
    }


    public Drink(String name,double rating, Double price, boolean nonAlcoholic) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.nonAlcoholic = nonAlcoholic;
    }

    public Drink(int id, String name, Double price, boolean nonAlcoholic, double rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.nonAlcoholic = nonAlcoholic;
        this.rating = rating;
    }




    @Override
    public int compareTo(Drink otherDrink) {
     return Double.compare(this.getRating(), otherDrink.getRating());

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

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return String.format("| %-25s | $%-6.2f | %-7.1f |", name, price, rating);
    }
}
