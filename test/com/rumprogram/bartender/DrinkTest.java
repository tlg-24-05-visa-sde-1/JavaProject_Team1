package com.rumprogram.bartender;

import com.rumprogram.Drink;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrinkTest {


//    @Test
//    public void testDrinkGetterSetter() {
//        Drink drink = new Drink(1, "Amaretto Sour", 8.00, true, 3);
//
//        assertEquals("Amaretto Sour", drink.getName());
//        assertEquals(8.00, drink.getPrice());
//        assertFalse(drink.isNonAlcoholic());
//        assertEquals(4, drink.getRating());
//        assertEquals(1, drink.getID());
//    }

    @Test
    public void testCompareTo() {
        Drink drink1 = new Drink(1, "Amaretto Sour", 8.00, true, 3);
        Drink drink2 = new Drink(2, "Aperol Spritz", 10.00, true, 3);
        Drink drink3 = new Drink(3, "Apple Mint Spritzer", 5.50, false, 2);
        Drink drink4 = new Drink(4, "Arnold Palmer", 5.00, true, 4);

        assertTrue(drink1.compareTo(drink3) > 0);
        assertTrue(drink1.compareTo(drink4) < 0);
        assertTrue(drink1.compareTo(drink2) == 0);
    }

    @Test
    public void testNonAlcoholic() {
        Drink nonAlcoholicDrink = new Drink(1, "Amaretto Sour", 8.00, true, 3);
        Drink alcoholicDrink = new Drink(3, "Apple Mint Spritzer", 5.00, false, 2);

        assertFalse(alcoholicDrink.isNonAlcoholic());
        assertTrue(nonAlcoholicDrink.isNonAlcoholic());
    }



}
