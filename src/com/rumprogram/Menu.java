package com.rumprogram;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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

  public static void sortByPriceHighestToLowest(){
      Map<String,Double> priceSort = new HashMap<>();

      String line;
      String splitBy = ",";

      try(BufferedReader br = new BufferedReader(new FileReader(DRINK_MENU))) {
          while ((line = br.readLine()) != null){
              String[] drinks = line.split(splitBy);
              String name = drinks[1].trim();
              Double price = Double.valueOf(drinks[4].trim());
              priceSort.put(name,price);

          }
      }catch(IOException e){
          e.printStackTrace();
      }

      List<Map.Entry<String, Double>> sortedList = new ArrayList<>(priceSort.entrySet());
      sortedList.sort(Map.Entry.<String, Double>comparingByValue());

      for(Map.Entry<String,Double> entry : sortedList){
          String name = entry.getKey();
          Double price = entry.getValue();
          System.out.println("Drink Name: " + name + " Price " + price);
      }
  }





}