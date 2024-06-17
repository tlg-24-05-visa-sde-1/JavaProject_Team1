package com.rumprogram;

import java.io.FileInputStream;
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
      Scanner sc = new Scanner("data/drink-data.csv");
      sc.useDelimiter(",");
      while (sc.hasNext()){

      }
      System.out.println(sc.hasNext());
      sc.close();
  }





}