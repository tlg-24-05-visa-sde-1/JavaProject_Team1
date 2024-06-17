package com.rumprogram;

public class Tab {
  // static properties & methods
  private static final int MAX_DRINKS = 3;

  // properties
  private int currentDrinkCount;
  private Double tabTotal;

  // constructors
  public Tab() {

  }

  // business methods
  private void updateTab(Double drinkPrice) {
    // add price to total
    // increment currentDrinkCount
  }

  // accessor methods
  public int getCurrentDrinkCount() {
    return currentDrinkCount;
  }

  public Double getTabTotal() {
    return tabTotal;
  }
}