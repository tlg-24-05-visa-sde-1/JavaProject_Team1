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
  private final Tab tab = new Tab();

  public void execute() {
    welcome();
    boolean anotherDrink = true;

    while (anotherDrink) {
      offerMenu();
      Drink drinkChoice = promptForDrinkChoice();
      makeDrink(drinkChoice);
      tab.updateTab(drinkChoice);
      anotherDrink = askIfTheyWantAnotherDrink(tab);
    }
    closeTab();
  }

  private void welcome() {
    try {
      String welcomeData = Files.readString(Path.of(WELCOME_DATA));
      System.out.println(welcomeData);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void offerMenu() {
    menu.readMenu();
  }

  private Drink promptForDrinkChoice() {
    Drink drinkChoice = null;

    String input = prompter.prompt("Which drink would you like? Please tell me the name: ");

      for (Drink drink : Menu.drinkMenu) {
        if (drink.getName().equalsIgnoreCase(input.trim())) {
          drinkChoice = drink;
          break;
        }
      }
    return drinkChoice;
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
      loadingScreens.add(SCREEN1);
      loadingScreens.add(SCREEN2);
      loadingScreens.add(SCREEN3);
      loadingScreens.add(SCREEN4);

      // generate loading screen
      for (String loadingScreen : loadingScreens) {
        try {
          System.out.println(loadingScreen);
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      clear();
      System.out.printf("Voilà! Enjoy your %s", drinkChoice.getName());

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private boolean askIfTheyWantAnotherDrink(Tab tab) {
    boolean another;

    if (tab.getCurrentDrinkCount() == Tab.MAX_DRINKS) {
      another = false;
    } else {
      String input = prompter.prompt("Would you like another drink? [Y/N]  ");
      if (input.equalsIgnoreCase("Y")) {
        another = true;
      } else {
        another = false;
      }
    }
    return another;
  }

  private void closeTab() {

    System.out.println("Thank you for visiting Rum Program! Here is the check.\n");
    System.out.println(tab);
  }

}
