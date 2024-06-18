package com.rumprogram;

import org.junit.Test;
import java.util.Collection;
import java.util.List;

import static java.util.Comparator.comparing;
import static org.junit.Assert.*;

public class MenuTest {

  @Test
  public void getMenu_shouldReturnDrinkCollection() {
    Menu menu = new Menu();
    Collection<Drink> drinks = menu.getMenu();
    System.out.println(drinks);
  }

  @Test
  public void sortByPriceLowestToHighest() {
    Menu menu = new Menu();
    List<Drink> drinks = menu.getMenu().stream()
      .sorted(comparing(Drink::getPrice))
      .toList();

    dump(drinks);
  }


  private static void dump(Collection<?> collection) {
    collection.forEach(System.out::println);
  }
}