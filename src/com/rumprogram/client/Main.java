package com.rumprogram.client;

import com.rumprogram.Menu;
import com.rumprogram.bartender.Bartender;

class Main {

  public static void main(String[] args){
    // instantiate controller and say "go"
//    Bartender bartender = new Bartender();
//    bartender.execute();
    Menu menu = new Menu();
    menu.showMenu();

  }
}