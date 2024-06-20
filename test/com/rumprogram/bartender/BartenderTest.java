package com.rumprogram.bartender;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class BartenderTest {
    private Bartender bartender;

    @Before
    public void setUp() {
        bartender = new Bartender();
    }

    @Test
    public void askIfTheyWantAnotherDrink_shouldReturnFalse_ifMaxDrinksAlreadyReached() {
        // set currentDrinkCount to max
        bartender.tab.updateCurrentDrinkCount();
        bartender.tab.updateCurrentDrinkCount();
        bartender.tab.updateCurrentDrinkCount();
        assertEquals(false, bartender.askIfTheyWantAnotherDrink(bartender.tab));
    }

    @Test
    public void askIfTheyWantAnotherDrink_shouldReturnTrue_ifMaxDrinksNotReachedAndValidYes() {
        assertEquals(true, bartender.askIfTheyWantAnotherDrink(bartender.tab));
    }

    @Test
    public void askIfTheyWantAnotherDrink_shouldReturnFalse_ifMaxDrinksNotReachedAndValidNo() {
        assertEquals(false, bartender.askIfTheyWantAnotherDrink(bartender.tab));
    }

    @Test(expected = IllegalArgumentException.class)
    public void askIfTheyWantAnotherDrink_shouldThrowIllegalArgumentException_ifMaxDrinksNotReachedAndInvalidResponse() {
        bartender.askIfTheyWantAnotherDrink(bartender.tab);
    }
}
