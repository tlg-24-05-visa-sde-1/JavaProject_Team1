package com.rumprogram;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static java.util.Comparator.comparing;

public class Menu {

  private static final String DRINK_MENU = "data/drink-data.csv";
  private static Collection<Drink> drinkMenu = new ArrayList<>();

  // constructors
  public Menu() {
    setMenu();
  }

  // accessor methods
  public static void readMenu() {
    String line;
    String splitBy = ",";

    List<Drink> menu = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(DRINK_MENU))) {
      while ((line = br.readLine()) != null) {
        String[] drinkData = line.split(splitBy);
        String name = drinkData[1].trim();
        Double price = Double.valueOf(drinkData[2].trim());
        Double rating = Double.valueOf(drinkData[4].trim());
        menu.add(new Drink(name, price, rating));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    Collections.sort(menu);

    for (Drink drink : menu) {
      System.out.println(drink);
    }
  }

  public static List<Drink> sortByPriceLowestToHighest() {
    List<Drink> drinks = drinkMenu.stream()
      .sorted(comparing(Drink::getPrice).reversed())
      .toList();

    return drinks;
  }

    public static void findMocktails () {
      List<Drink> mockTailSort = new ArrayList<>();
      String line;
      String splitBy = ",";

      try (BufferedReader br = new BufferedReader(new FileReader(DRINK_MENU))) {
        while ((line = br.readLine()) != null) {
          String[] drinks = line.split(splitBy);
          String name = drinks[1].trim();
          double rating = Double.valueOf(drinks[2].trim());
          Double price = Double.valueOf(drinks[4].trim());
          boolean nonAlcoholic = Boolean.parseBoolean(drinks[3].trim());

          if (nonAlcoholic) {
            Drink drink = new Drink(name, rating, price, nonAlcoholic);
            mockTailSort.add(drink);
          }

        }
      } catch (IOException e) {
        e.printStackTrace();
      }
      for (Drink entry : mockTailSort) {
        System.out.println(entry);
      }
    }

    private void setMenu () {
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

    public Collection<Drink> getMenu () {
      return drinkMenu;
    }
  }