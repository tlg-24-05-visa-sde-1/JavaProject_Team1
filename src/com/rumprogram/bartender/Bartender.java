package com.rumprogram.bartender;

import com.rumprogram.Tab;
import com.rumprogram.Menu;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Bartender {

  // static
  private static final String WELCOME_DATA = "data/welcome.txt";

  private final Menu menu = new Menu();
  private final Scanner scanner = new Scanner(System.in);
  private final Tab tab = new Tab();

  public void execute() {
    welcome();
    boolean anotherDrink = true;

/*    while (anotherDrink) {
      offerMenu();
      String drinkChoice = promptForDrinkChoice();
      makeDrink();
      updateTab();
      // collectRating(); * nice to have
      anotherDrink = askIfTheyWantAnotherDrink(); // update anotherDrink
    }
    closeTab();*/
  }

/*    private boolean askIfTheyWantAnotherDrink() {
      boolean another;
      if (max > MAX) {
        another = false;
      }
      else if (they say yes) {
        another = true;
      }
      else {
        another = false;
      }
      return another;
    }*/

  private void welcome() {

    try {
      String welcomeData = Files.readString(Path.of("data/welcome.txt"));
      System.out.println(welcomeData);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
