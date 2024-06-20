package com.rumprogram.bartender;

import com.rumprogram.Tab;
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
        // set currentDrinkCount
        bartender.tab.updateCurrentDrinkCount();
        bartender.tab.updateCurrentDrinkCount();
        bartender.tab.updateCurrentDrinkCount();
        assertEquals(false, bartender.askIfTheyWantAnotherDrink(bartender.tab));
    }

    @Test
    public void askIfTheyWantAnotherDrink_shouldReturnTrue_ifMaxDrinksNotReachedAndValidYes() {
        // set currentDrinkCount
        assertEquals(true, bartender.askIfTheyWantAnotherDrink(bartender.tab));
    }

    @Test
    public void askIfTheyWantAnotherDrink_shouldReturnFalse_ifMaxDrinksNotReachedAndValidNo() {
        // set currentDrinkCount
        assertEquals(false, bartender.askIfTheyWantAnotherDrink(bartender.tab));
    }

    @Test(expected = IllegalArgumentException.class)
    public void askIfTheyWantAnotherDrink_shouldThrowIllegalArgumentException_ifMaxDrinksNotReachedAndInvalidResponse() {
        // set currentDrinkCount
        bartender.askIfTheyWantAnotherDrink(bartender.tab);
    }
}
