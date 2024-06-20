package com.rumprogram;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static com.rumprogram.Tab.drinksOrdered;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TabTest {
    private Tab tab;
    private Drink drink1;
    private Drink drink2;

    @Before
    public void setUp() {
        tab = new Tab();
        drink1 = new Drink("Rum", 5.0);
        drink2 = new Drink("Whiskey", 7.5);
    }

    // Test the tab total and drink total
    @Test
    public void testDrinksAddition() {
        tab.updateTab(drink1);
        tab.updateTab(drink2);

        assertEquals(12.5, tab.getTabTotal(), .001);
        assertEquals(2, tab.getCurrentDrinkCount());
        Collection<Drink> drinksOrdered = tab.getDrinksOrdered();
        assertTrue(drinksOrdered.contains(drink1));
        assertTrue(drinksOrdered.contains(drink2));
    }

    // Test that MaxDrinks cuts off the user
    @Test
    public void testMaxDrinks() {
        for (int i = 0; i < tab.getTabTotal(); i++) {
            tab.updateTab(drink1);
        }
        assertEquals(Tab.MAX_DRINKS + 1, tab.getCurrentDrinkCount());
    }


    // Test exception if the drink request is not on list (or mispelled, etc.)
    @Test
    public void testAddDrinkNotInList() {
        assertThrows(NullPointerException.class, () -> tab.updateTab(null));

    }

}