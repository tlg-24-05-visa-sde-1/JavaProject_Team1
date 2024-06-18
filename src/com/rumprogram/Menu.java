package com.rumprogram;

import java.io.*;
import java.util.*;

import com.apps.util.Prompter;

import static com.apps.util.Console.clear;
import static java.util.Comparator.comparing;

public class Menu {

  private static final Prompter prompter = new Prompter(new Scanner(System.in));
  private static final String DRINK_MENU = "data/drink-data.csv";
  private static Collection<Drink> drinkMenu = new ArrayList<>();

  // constructors
  public Menu() {
    setMenu();
  }

  // accessor methods
  public static Drink readMenu() {

    Drink drink = null;
    boolean keepReading = true;

    // Show menu sorted by rating.
    System.out.println("\nHere you go!\nOur menu is automatically sorted by name.\n");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }

    dump(drinkMenu);

    // While still reading
    while(keepReading) {
      System.out.println("\n\nWould you like to view the menu a different way, or are you ready to order?\n");
      System.out.println("""
           1 = Sort by rating
           2 = Sort by price, lowest to highest
           3 = Only show mocktail options
           4 = I'm ready to order!""");

      String input = prompter.prompt("Please type the number of your selection: ");

      clear();

      switch(Integer.parseInt(input.trim())) {
        case 1 -> dump(sortByRating());
        case 2 -> dump(sortByPriceLowestToHighest());
        case 3 -> dump(findMocktails());
        case 4 -> keepReading = false;
      }
    }
    drink = promptForDrinkChoice();
    return drink;
  }

  private static Drink promptForDrinkChoice() {
    Drink drinkChoice = null;

    String input = prompter.prompt("Please type the name of the drink you would like: ");

    for (Drink drink : drinkMenu) {
      if (drink.getName().equalsIgnoreCase(input.trim())) {
        drinkChoice = drink;
      }
    }
    return drinkChoice;
  }

  public static List<Drink> sortByPriceLowestToHighest() {
    List<Drink> drinks = drinkMenu.stream()
      .sorted(comparing(Drink::getPrice).reversed())
      .toList();

    return drinks;
  }

  public static List<Drink> findMocktails() {
    List<Drink> drinks = drinkMenu.stream()
      .filter(Drink::isNonAlcoholic)
      .toList();

    return drinks;
  }

  public static List<Drink> sortByRating() {
    List<Drink> drinks = drinkMenu.stream()
      .sorted(comparing(Drink::getRating).reversed())
      .toList();

    return drinks;
  }

  private static void dump(Collection<?> collection) {
    collection.forEach(System.out::println);
  }

  private void setMenu() {
    String line;
    String splitBy = ",";

    Collection<Drink> menu = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(DRINK_MENU))) {
      while ((line = br.readLine()) != null) {
        String[] drinkData = line.split(splitBy);
        int id = Integer.parseInt(drinkData[0].trim());
        String name = drinkData[1].trim();
        double price = Double.parseDouble(drinkData[2].trim());
        boolean nonAlcoholic = Boolean.parseBoolean(drinkData[3].trim());
        double rating = Double.parseDouble(drinkData[4].trim());
        menu.add(new Drink(id, name, price, nonAlcoholic, rating));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    drinkMenu = menu;
  }

  public Collection<Drink> getMenu() {
    return drinkMenu;
  }
}