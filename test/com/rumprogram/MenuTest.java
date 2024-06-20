package com.rumprogram;

import org.junit.Test;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

  @Test
  public void sortByRatingHighesToLowest() {
    Menu menu = new Menu();
    List<Drink> drinks = menu.getMenu().stream()
            .sorted(comparing(Drink::getRating).reversed())
            .toList();

    dump(drinks);
  }

  @Test
  public void userInputShouldReturn_drinkObjectThatIsInDrinkMenu() {
    Menu menu = new Menu();
    assertEquals("Martini",menu.promptForDrinkChoice().getName());


  }

  @Test
  public void findMocktails() {

    Menu menu = new Menu();
    List<Drink> drinks = menu.getMenu().stream()
                    .filter(Drink::isNonAlcoholic)
                     .collect(Collectors.toList());

    dump(drinks);

  }

  private static void dump(Collection<?> collection) {
    collection.forEach(System.out::println);
  }
}