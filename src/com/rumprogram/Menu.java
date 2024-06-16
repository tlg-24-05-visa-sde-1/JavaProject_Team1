package com.rumprogram;

import java.util.Collection;

class Menu {

  // properties
  private final Collection<Drink> drinkMenu = new ArrayList<Drink>();

  // constructors

  // business methods
  // readMenu() * decides which class method to run based on how the guest would like to read the content
  // sortByRating()
  // sortByPriceLowestToHighest()
  // findMocktails()

  // accessor methods

  // MEMBER-LEVEL NAMED INNER CLASS
  private class Drink implements Comparable<Drink> {

    // properties
    private final String name;
    private final Double price;
    private final boolean nonAlcoholic;
    private final int id;
    private final Double rating;


    Drink(String name, Double price, boolean nonAlcoholic, int id, Double rating) {
      this.name = name;
      this.price = price;
      this.nonAlcoholic = nonAlcoholic;
      this.id = id;
      this.rating = rating;
    }

    @Override
    public int compareTo(Drink o) {
      return 0;
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
  }
}