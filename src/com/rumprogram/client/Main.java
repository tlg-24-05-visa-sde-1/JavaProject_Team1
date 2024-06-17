package com.rumprogram.client;

import com.rumprogram.bartender.Bartender;

class Main {

  public static void main(String[] args){
    // instantiate controller and say "go"
    BarGuest guest = new BarGuest();
    guest.execute();
  }
}