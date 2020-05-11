package com.yannickfin.var.historical.calculation;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertSame;
import static junit.framework.TestCase.assertEquals;

public class PercentageCalculationTest {

    @Test(expected=IllegalArgumentException.class)
    public void itShouldThrowsAnExceptionIfTheInputValueIsNull() throws IllegalArgumentException {
        new PercentageCalculation(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void itShouldThrowsAnExceptionIfTheInputValueIsEmpty() throws IllegalArgumentException {
        double[] emptyRawData = {};
        new PercentageCalculation(emptyRawData);
    }

    @Test
    public void itShouldInitialiseTheRawValuesWithTheHistoricalValues() {
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

        PercentageCalculation testPercentageCalculation = new PercentageCalculation(historicalTradesValues);

        assertEquals(Arrays.toString(historicalTradesValues), Arrays.toString(testPercentageCalculation.getRawValues()));
    }

    @Test
    public void itShouldInitialiseThePercentageValues() {
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

        double[] expectedPercentages = {
                0.1475,
                0.2380,
                -0.5171,
                -0.1294,
                0.5910,
                0.3140,
                0.7149,
                -0.6360,
                -0.3478,
                0.0828,
                1.8885,
                1.7327
        };

        PercentageCalculation testPercentageCalculation = new PercentageCalculation(historicalTradesValues);

        assertEquals(Arrays.toString(expectedPercentages), Arrays.toString(testPercentageCalculation.getArrayPercentageChangesAcrossHistory()));
    }
}
