package com.rumprogram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Tab {
  // static properties & methods
  public static final int MAX_DRINKS = 3;

  // properties
  private int currentDrinkCount;
  private double tabTotal;
  private static Collection<Drink> drinksOrdered = new ArrayList<>();

  // business methods
  public void updateTab(Drink drinkOrdered) {
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

  private static String itemizeDrinks() {
    String drinkReceipt = "";

    for (Drink drink : drinksOrdered) {
      drinkReceipt += String.format("%s  $%,.2f", drink.getName(), drink.getPrice());
    }
    return drinkReceipt;
  }

  // toString()
  @Override
  public String toString() {
    return String.format("%s: currentDrinkCount=%s\n\n drinksOrdered=%s\n\n tabTotal=%,.2f",
      getClass().getSimpleName(), getCurrentDrinkCount(), itemizeDrinks(), getTabTotal());
  }
}