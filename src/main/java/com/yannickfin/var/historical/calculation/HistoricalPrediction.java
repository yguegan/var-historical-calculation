package com.yannickfin.var.historical.calculation;

import com.yannickfin.var.historical.calculation.utils.CalculationUtils;

import java.util.List;

/**
 * Class that compute the final result of the historical prediction VaR
 */
public class HistoricalPrediction implements RiskPrediction {

    private final List<DataExtractor> listDataExtractor;

    /**
     * Constructor
     * @param listDataExtractor a list of the object that is compute the intermediate values for each portfolio
     */
    public HistoricalPrediction(List<DataExtractor> listDataExtractor) {
        this.listDataExtractor = listDataExtractor;
    }

    /**
     * Compute the VaR based on the intermediate value computed
     * @param indexDataExtractor is the index related to the targeted dataExtractor
     * @param periodUnit is the number of days for the prediction
     * @return double
     */
    public double getValueAtRiskValueFor(int indexDataExtractor, int periodUnit) {
        DataExtractor dataExtractor = listDataExtractor.get(indexDataExtractor);
        double rawResult = dataExtractor.getCurrentQuoteForStock() * dataExtractor.getGlobalAverageDeltaCalculation() * dataExtractor.getConfidenceLevel() * periodUnit;

        return CalculationUtils.renderDoubleValueWithRightPrecision(rawResult, CalculationUtils.FORMAT_WITH_FOUR_DECIMALS);
    }

    /**
     * Compute the VaR based on the intermediate value computed
     * @param periodUnit is the number of days for the prediction
     * @return double
     */
    public double getValueAtRiskValueForPortfolio(int periodUnit) {
        double rawResult = 0.0;
        for(int indexDataExtractor=0; indexDataExtractor<listDataExtractor.size(); indexDataExtractor++) {
            rawResult += getValueAtRiskValueFor(indexDataExtractor, periodUnit);

        }
        return CalculationUtils.renderDoubleValueWithRightPrecision(rawResult, CalculationUtils.FORMAT_WITH_FOUR_DECIMALS);
    }
}
