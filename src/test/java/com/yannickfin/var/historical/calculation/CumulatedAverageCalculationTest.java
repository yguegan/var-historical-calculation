package com.yannickfin.var.historical.calculation;

import org.junit.Test;

import java.util.Arrays;

import static junit.framework.Assert.assertSame;
import static junit.framework.TestCase.assertEquals;

public class CumulatedAverageCalculationTest {

    @Test(expected=IllegalArgumentException.class)
    public void itShouldThrowsAnExceptionIfTheInputValueIsNull() throws IllegalArgumentException {
        new CumulatedAverageCalculation(null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void itShouldThrowsAnExceptionIfTheInputValueIsEmpty() throws IllegalArgumentException {
        double[] emptyValuesToUse = {};
        new CumulatedAverageCalculation(emptyValuesToUse);
    }

    @Test
    public void itShouldInitialiseTheValuesToCompareWithThePercentages() {
        double[] percentages = {
                0.147495,
                0.238036,
                -0.517110,
                -0.129415,
                0.590975,
                0.313962,
                0.714897,
                -0.635971,
                -0.347791,
                0.082770,
                1.888487,
                1.732678
        };

        CumulatedAverageCalculation testCumulatedAverageCalculation = new CumulatedAverageCalculation(percentages);

        assertEquals(Arrays.toString(percentages), Arrays.toString(testCumulatedAverageCalculation.getValuesToCompare()));
    }

    @Test
    public void itShouldInitialiseTheHistoricalCumulatedAverageDelta() {
        double[] percentages = {
                0.147495,
                0.238036,
                -0.517110,
                -0.129415,
                0.590975,
                0.313962,
                0.714897,
                -0.635971,
                -0.347791,
                0.082770,
                1.888487,
                1.732678
        };

        double[] expectedHistoricalCumulatedAverageDelta = {
                0.0881,
                0.0288,
                -0.1804,
                0.1564,
                0.4423,
                0.2936,
                0.2733,
                -0.1682,
                0.2995,
                0.9467,
                1.8106,
                1.7327
        };

        CumulatedAverageCalculation testCumulatedAverageCalculation = new CumulatedAverageCalculation(percentages);

        assertEquals(Arrays.toString(expectedHistoricalCumulatedAverageDelta), Arrays.toString(testCumulatedAverageCalculation.getCumulatedAverage()));
    }

    @Test
    public void itShouldReturnTheAverageOfAllTheCumulatedAverageDelta() {
        double[] percentages = {
                0.147495,
                0.238036,
                -0.517110,
                -0.129415,
                0.590975,
                0.313962,
                0.714897,
                -0.635971,
                -0.347791,
                0.082770,
                1.888487,
                1.732678
        };

        CumulatedAverageCalculation testCumulatedAverageCalculation = new CumulatedAverageCalculation(percentages);

        assertEquals(0.4769, testCumulatedAverageCalculation.calculateDelta());
    }
}
