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
  public static int lastMenuSort;

  // constructors
  public Menu() {
    setMenu();
  }

  // accessor methods
  public static Drink readMenu() {

    Drink drink = null;

    clear();

    // Show menu sorted by rating.
    System.out.println("\nHere you go!\nOur menu is automatically sorted by name.\n");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
       e.printStackTrace();
    }

    dump(drinkMenu);
    boolean keepReading = true;

    while(keepReading) {

      String choice = menuOptions();

      switch(Integer.parseInt(choice.trim())) {
        case 1 -> sortByRating();
        case 2 -> sortByPriceLowestToHighest();
        case 3 -> findMocktails();
        case 4 -> keepReading = false;
      }
    }

    quickSort();

    drink = promptForDrinkChoice();
    return drink;
  }

  public static void quickSort() {
    clear();
    if (lastMenuSort == 1) {
      sortByRating();
    }
    else if (lastMenuSort == 2) {
      sortByPriceLowestToHighest();
    }
    else if (lastMenuSort == 3) {
      findMocktails();
    }
  }

  public static String menuOptions() {

    System.out.println("\n\nWould you like to view the menu a different way, or are you ready to order?\n");
    System.out.println("""
           1 = Sort by rating
           2 = Sort by price, lowest to highest
           3 = Only show mocktail options
           4 = I'm ready to order!""");

    return prompter.prompt("\nPlease type the number of your selection: ");
  }

  public static Drink promptForDrinkChoice() {
    Drink drinkChoice = null;

    String input = null;
    boolean keepAsking = true;

    while (keepAsking) {

      quickSort();

      input = prompter.prompt("\nPlease type the name of the drink you would like: ");
      // input = "Martini"; // hardcoding for test method

      for (Drink drink : drinkMenu) {
        if (drink.getName().equalsIgnoreCase(input.trim())) {
          drinkChoice = drink;
          keepAsking = false;
        }
      }
    }
      return drinkChoice;
  }

  public static void sortByRating() {
    List<Drink> drinks = drinkMenu.stream()
      .sorted(comparing(Drink::getRating).reversed())
      .toList();

    setLastMenuSort(1);
    clear();
    dump(drinks);
  }

  public static void sortByPriceLowestToHighest() {
    List<Drink> drinks = drinkMenu.stream()
      .sorted(comparing(Drink::getPrice))
      .toList();

    setLastMenuSort(2);
    clear();
    dump(drinks);
  }

  public static void findMocktails() {
    List<Drink> drinks = drinkMenu.stream()
      .filter(Drink::isNonAlcoholic)
      .toList();

    setLastMenuSort(3);
    clear();
    dump(drinks);
  }



  private static void dump(Collection<?> collection) {

//    collection.forEach(System.out::println);
    System.out.println("+-------------------------------+----------+---------+");
    System.out.println("| Name                           |Price    |  Rating |");
    System.out.println("+-------------------------------+----------+---------+");
    int index = 1;

    for(Object drink: collection){
      System.out.printf("| %2d %s%n", index++, drink.toString());
    }
  }

  public static void setLastMenuSort(int sortNumber) {
    lastMenuSort = sortNumber;
  }

  public int getLastMenuSort() {
    return lastMenuSort;
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