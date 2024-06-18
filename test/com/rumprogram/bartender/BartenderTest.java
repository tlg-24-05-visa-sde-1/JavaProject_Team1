package com.rumprogram.bartender;

import com.rumprogram.Drink;
import org.junit.Before;
import org.junit.Test;

public class BartenderTest {
    private Bartender bartender;


    @Before
    public void setUp() {
        bartender = new Bartender();
    }

    @Test
    public void testMakeDrink(){
        Drink drink = new Drink(1, "Amaretto Sour", 8.00, true, 3);

    }

    @Test
    public void testPromptForDrinkChoice(){

    }

    @Test
    public void testAskAnotherDrink(){

    }

}
