package com.rumprogram.controller;

import com.rumprogram.bartender.Bartender;

class BarGuest {

  private final Bartender bartender = new Bartender();

  public BarGuest() {

  }

  public void execute() {
    bartender.execute();
  }
}