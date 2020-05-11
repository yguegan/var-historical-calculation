package com.yannickfin.var.historical.calculation;

import com.yannickfin.var.historical.calculation.utils.CalculationUtils;
import java.util.Arrays;

/**
 * Class that will compute the average for the different delta across the historic
 */
public class CumulatedAverageCalculation {

    private final double[] valuesToCompare;
    private final double[] cumulatedAverage;

    /**
     * COnstructor
     * @param valuesToCompare values needed to compute the average
     * @throws IllegalArgumentException may be triggered if the input is null or empty array
     */
    public CumulatedAverageCalculation(double[] valuesToCompare) throws IllegalArgumentException{
        if(valuesToCompare != null && valuesToCompare.length > 0) {
            this.valuesToCompare = valuesToCompare;
            this.cumulatedAverage = calculateAverage();
        } else {
            throw new IllegalArgumentException("The valueToCompare input cannot be null or empty array");
        }
    }

    /**
     * Calculate the cumulated average for all the delta across the historic
     * @return double[]
     */
    public double[] calculateAverage() {
        double[] historicalCumulatedAverageDelta = new double[this.valuesToCompare.length];
        int lastElementIndex = this.valuesToCompare.length - 1;
        double cumulatedAverage = CalculationUtils.renderDoubleValueWithRightPrecision(this.valuesToCompare[lastElementIndex], CalculationUtils.FORMAT_WITH_FOUR_DECIMALS);
        historicalCumulatedAverageDelta[lastElementIndex] = cumulatedAverage;

        for (int dailyAverage = lastElementIndex-1; dailyAverage >= 0; dailyAverage--) {
            cumulatedAverage = CalculationUtils.renderDoubleValueWithRightPrecision((cumulatedAverage + this.valuesToCompare[dailyAverage])/2d, CalculationUtils.FORMAT_WITH_FOUR_DECIMALS);
            historicalCumulatedAverageDelta[dailyAverage] = cumulatedAverage;
        }
        return historicalCumulatedAverageDelta;
    }

    public double[] getValuesToCompare() {
        return valuesToCompare;
    }

    public double[] getCumulatedAverage() {
        return cumulatedAverage;
    }

    /**
     * Calculate the average of all the cumulated average
     * @return double
     */
    public double calculateDelta() {
        double totalAverage = 0.0;
        for(double averageDelta: this.cumulatedAverage){
            totalAverage += averageDelta;
        }

        double globalAverage = totalAverage/(double) this.cumulatedAverage.length;

        return CalculationUtils.renderDoubleValueWithRightPrecision(globalAverage, CalculationUtils.FORMAT_WITH_FOUR_DECIMALS);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CumulatedAverageCalculation that = (CumulatedAverageCalculation) o;
        return Arrays.equals(valuesToCompare, that.valuesToCompare) &&
                Arrays.equals(cumulatedAverage, that.cumulatedAverage);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(valuesToCompare);
        result = 31 * result + Arrays.hashCode(cumulatedAverage);
        return result;
    }
}
