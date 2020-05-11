package com.yannickfin.var.historical.calculation;

import org.junit.Test;


import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertSame;

public class StockTest {

    @Test(expected=IllegalArgumentException.class)
    public void itShouldThrowsAnExceptionIfTheInputValueIsNull() throws IllegalArgumentException {
        Stock stock = new Stock(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void itShouldThrowsAnExceptionIfTheInputValueIsEmpty() throws IllegalArgumentException {
        double[] emptyHistoricStock = {};
        Stock stock = new Stock(emptyHistoricStock);
    }

    @Test
    public void itShouldCreateAStockBasedOnTheValuesInjectedAsInput() {
        double[] historicalTradesValues = {
                0.00894517,
                0.00779539,
                0.00629658,
                0.01303937,
                0.01497771,
                0.00941417,
                0.00716472,
                0.00417793,
                0.01147693,
                0.01759701,
                0.01625184,
                0.00562642,
                0.00205894
        };

        Stock testStock = new Stock(historicalTradesValues);

        assertSame(testStock.getHistoricalValues(), historicalTradesValues);
    }

    @Test
    public void itShouldInitialiseTheCurrentQuoteValueWithTheMostRecentTradeValue() {
        double[] historicalTradesValues = {
                0.00894517,
                0.00779539,
                0.00629658,
                0.01303937,
                0.01497771,
                0.00941417,
                0.00716472,
                0.00417793,
                0.01147693,
                0.01759701,
                0.01625184,
                0.00562642,
                0.00205894
        };

        Stock testStock = new Stock(historicalTradesValues);

        assertEquals(testStock.getCurrentQuote(), historicalTradesValues[0]);
    }
}
