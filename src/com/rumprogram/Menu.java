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
  public static void readMenu () {
      String line;
      String splitBy = ",";

      List<Drink> menu = new ArrayList<>();
      try(BufferedReader br = new BufferedReader(new FileReader(DRINK_MENU))) {
         while ((line = br.readLine()) !=null){
             String[] drinkData = line.split(splitBy);
             String name = drinkData[1].trim();
             Double price = Double.valueOf(drinkData[2].trim());
             Double rating = Double.valueOf(drinkData[4].trim());
             menu.add(new Drink(name,price,rating));


         }
      } catch (IOException e) {
          e.printStackTrace();
      }
      Collections.sort(menu);

      for(Drink drink : menu){
          System.out.println(drink);
      }
  }

  public static void sortByPriceLowestToHighest(){
      Map<String,Drink> priceSort = new HashMap<>();

      String line;
      String splitBy = ",";

      try(BufferedReader br = new BufferedReader(new FileReader(DRINK_MENU))) {
          while ((line = br.readLine()) != null){
              String[] drinks = line.split(splitBy);
              String name = drinks[1].trim();
              Double price = Double.valueOf(drinks[2].trim());
              Double rating = Double.valueOf(drinks[4].trim());
              priceSort.put(name,new Drink(name,price,rating));

          }
      }catch(IOException e){
          e.printStackTrace();
      }

      List<Map.Entry<String, Drink>> sortedList = new ArrayList<>(priceSort.entrySet());
      sortedList.sort(Comparator.comparing(price ->price.getValue().getPrice()));

      for(Map.Entry<String,Drink> entry : sortedList){
          String name = entry.getKey();
          Double price = entry.getValue().getPrice();
          Double rating = entry.getValue().getRating();
          System.out.println(name + " Price " + price + " Rating " + rating);
      }
  }

  public static void findMocktails(){
      List<Drink> mockTailSort = new ArrayList<>();
      String line;
      String splitBy = ",";

      try(BufferedReader br = new BufferedReader(new FileReader(DRINK_MENU))) {
          while ((line = br.readLine()) != null){
              String[] drinks = line.split(splitBy);
              String name = drinks[1].trim();
              double rating = Double.valueOf(drinks[2].trim());
              Double price = Double.valueOf(drinks[4].trim());
              boolean nonAlcoholic = Boolean.parseBoolean(drinks[3].trim());

              if(nonAlcoholic){
                  Drink drink = new Drink(name,rating,price,nonAlcoholic);
                  mockTailSort.add(drink);
              }

          }
      }catch(IOException e){
          e.printStackTrace();
      }
       for(Drink entry : mockTailSort){
           System.out.println(entry);
       }
  }




}