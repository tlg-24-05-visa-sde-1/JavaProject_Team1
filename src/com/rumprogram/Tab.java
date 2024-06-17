package com.rumprogram;

import java.util.Collection;

public class Tab {
  // static properties & methods
  private static final int MAX_DRINKS = 3;

  // properties
  private int currentDrinkCount;
  private double tabTotal;
  private Collection<Drink> drinksOrdered;

  // business methods
  private void updateTab(Drink drinkOrdered) {
    tabTotal += drinkOrdered.getPrice();
    drinksOrdered.add(drinkOrdered);
    currentDrinkCount++;
  }

  // accessor methods
  public int getCurrentDrinkCount() {
    return currentDrinkCount;
  }

  public double getTabTotal() {
    return tabTotal;
  }

  public Collection<Drink> getDrinksOrdered() {
    return drinksOrdered;
  }

  // toString()
  @Override
  public String toString() {
    return String.format("%s: currentDrinkCount=%s, drinksOrdered=%s, tabTotal=%,.2f",
      getClass().getSimpleName(), getCurrentDrinkCount(), getDrinksOrdered(), getTabTotal());
  }
}