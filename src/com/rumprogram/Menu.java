package com.rumprogram;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Menu {


   private static final String DRINK_MENU = "data/drink-data.csv";

  // properties
  private final Collection<Drink> drinkMenu = new ArrayList<Drink>();



  // constructors

  // business methods
  // readMenu() * decides which class method to run based on how the guest would like to read the content
  // sortByRating()
  // sortByPriceLowestToHighest()
  // findMocktails()

  // accessor methods
  public static void showMenu () {

      try {
          String welcomeData = Files.readString(Path.of(DRINK_MENU));
          System.out.println(welcomeData);
      } catch (IOException e) {
          e.printStackTrace();
      }
  }





}