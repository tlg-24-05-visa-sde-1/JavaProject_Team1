package com.rumprogram.bartender;

import com.apps.util.Prompter;
import com.rumprogram.Drink;
import com.rumprogram.Tab;
import com.rumprogram.Menu;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import java.util.Timer;

import static com.apps.util.Console.clear;

public class Bartender {

  // static
  private static final String WELCOME_DATA = "data/welcome.txt";
  private static final String SCREEN1 = "data/loadingScreen/screen1.txt";
  private static final String SCREEN2 = "data/loadingScreen/screen2.txt";
  private static final String SCREEN3 = "data/loadingScreen/screen3.txt";
  private static final String SCREEN4 = "data/loadingScreen/screen4.txt";

  private final Menu menu = new Menu();
  private final Prompter prompter = new Prompter(new Scanner(System.in));
  final Tab tab = new Tab();

  public void execute() {
    welcome();
    boolean anotherDrink = true;

    while (anotherDrink) {
      Drink drinkChoice = offerMenu();
      makeDrink(drinkChoice);
      tab.updateTab(drinkChoice);
      anotherDrink = askIfTheyWantAnotherDrink(tab);
    }
    clear();
    closeTab();
    try {
      Thread.sleep(2500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void welcome() {
    try {
      String welcomeData = Files.readString(Path.of(WELCOME_DATA));
      System.out.println(welcomeData);
      try {
        Thread.sleep(2500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private Drink offerMenu() {
    return menu.readMenu();
  }

  private void makeDrink(Drink drinkChoice) {
    Collection<String> loadingScreens = new ArrayList<>();

    try {
      // create paths to loading screens
      String screen1 = Files.readString(Path.of(SCREEN1));
      String screen2 = Files.readString(Path.of(SCREEN2));
      String screen3 = Files.readString(Path.of(SCREEN3));
      String screen4 = Files.readString(Path.of(SCREEN4));

      // add loading screens to collection
      loadingScreens.add(screen1);
      loadingScreens.add(screen2);
      loadingScreens.add(screen3);
      loadingScreens.add(screen4);

      // generate loading screen
      clear();
      for (String loadingScreen : loadingScreens) {
        try {
          System.out.println(loadingScreen);
          Thread.sleep(1500);
          clear();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      clear();

      System.out.printf("Voilà! Enjoy your %s\n", drinkChoice.getName());
      try {
        Thread.sleep(1750);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  boolean askIfTheyWantAnotherDrink(Tab tab) throws IllegalArgumentException {
    boolean another;

    if (tab.getCurrentDrinkCount() == Tab.MAX_DRINKS) {
      another = false;
      System.out.println("\u001B[1;31m You've hit the maximum amount! Come back and see us tomorrow.\u001B[0m");
      try {
        Thread.sleep(2500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    } else {
      String input = null;
      try {
        input = prompter.prompt("\n \u001B[1;32m Would you like another drink? [Y/N] \u001B[0m");
        // String input = "1" // hardcoding test method input
      } catch (IllegalArgumentException e) {
        throw new IllegalArgumentException("Invalid response: please type 'y' for yes, or 'n' for no.");
      }

      if (input.equalsIgnoreCase("Y")) {
        another = true;
      } else {
        another = false;
      }
    }
    return another;
  }

  private void closeTab() {

    System.out.println("\n\nThank you for visiting Rum Program! Here is the check.\n");
    System.out.println(tab);
  }

}
