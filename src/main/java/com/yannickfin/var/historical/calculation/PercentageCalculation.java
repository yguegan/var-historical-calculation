package com.yannickfin.var.historical.calculation;

import com.yannickfin.var.historical.calculation.utils.CalculationUtils;
import java.util.Arrays;

/**
 * Class to compute the percentage of the daily variation on the quote across the historic
 */
public class PercentageCalculation {

    private final double[] rawValues;
    private final double[] arrayPercentageChangesAcrossHistory;

    /**
     * Constructor
     * @param rawValues values for which the percentage of variation is needed
     * @throws IllegalArgumentException may be triggered if the input is null or empty array
     */
    public PercentageCalculation(double[] rawValues) throws IllegalArgumentException {
        if(rawValues != null && rawValues.length > 0) {
            this.rawValues = rawValues;
            this.arrayPercentageChangesAcrossHistory = calculatePercentageChangePerDay();
        } else {
            throw new IllegalArgumentException("The rawValues input cannot be null or empty array");
        }
    }

    public double[] getRawValues() {
        return rawValues;
    }

    public double[] getArrayPercentageChangesAcrossHistory() {
        return arrayPercentageChangesAcrossHistory;
    }

    /**
     * Calculate the percentage of the variation between day and day-1 across the historic
     * @return double[]
     */
    public double[] calculatePercentageChangePerDay() {
        double[] percentageChange = new double[rawValues.length - 1];
        int lastElementIndex = rawValues.length - 1;

        for (int dailyAverage = lastElementIndex-1; dailyAverage >= 0; dailyAverage--) {
            double todaySingleQuoteValue = rawValues[dailyAverage];
            double previousDaySingleQuoteValue = rawValues[dailyAverage + 1];
            double dailyPercentageChange = (todaySingleQuoteValue - previousDaySingleQuoteValue)/previousDaySingleQuoteValue;

            percentageChange[dailyAverage] = CalculationUtils.renderDoubleValueWithRightPrecision(dailyPercentageChange, CalculationUtils.FORMAT_WITH_FOUR_DECIMALS);
        }
        return percentageChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PercentageCalculation that = (PercentageCalculation) o;
        return Arrays.equals(rawValues, that.rawValues) &&
                Arrays.equals(arrayPercentageChangesAcrossHistory, that.arrayPercentageChangesAcrossHistory);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(rawValues);
        result = 31 * result + Arrays.hashCode(arrayPercentageChangesAcrossHistory);
        return result;
    }
}
