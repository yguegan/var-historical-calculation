package com.yannickfin.var.historical.calculation;

import java.util.Arrays;
import java.util.Objects;

/**
 * CLass that reflecting the information related to the Stock
 */
public class Stock {

    private final double currentQuote;
    private final double[] historicalValues;

    /**
     *
     * @param historicalValues historic calue for the stock
     * @throws IllegalArgumentException in case the parameter is null or empty or invalid
     */
    public Stock(double[] historicalValues) throws IllegalArgumentException {
        if(historicalValues != null && historicalValues.length > 0) {
            this.currentQuote = historicalValues[0];
            this.historicalValues = historicalValues;
        } else {
            throw new IllegalArgumentException("A stock historic must contain values");
        }
    }

    public double getCurrentQuote() {
        return currentQuote;
    }

    public double[] getHistoricalValues() {
        return historicalValues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Double.compare(stock.currentQuote, currentQuote) == 0 &&
                Arrays.equals(historicalValues, stock.historicalValues);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(currentQuote);
        result = 31 * result + Arrays.hashCode(historicalValues);
        return result;
    }
}
