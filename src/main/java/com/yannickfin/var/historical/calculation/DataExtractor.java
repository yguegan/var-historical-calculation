package com.yannickfin.var.historical.calculation;

import com.yannickfin.var.historical.calculation.utils.PropertiesExtractor;

/***
 * Class that will extract/compute all the intermediate data necessary
 */
public class DataExtractor {

    private final Stock stock;
    private final PercentageCalculation percentageCalculation;
    private final CumulatedAverageCalculation deltaCalculation;
    private final double globalAverageDeltaCalculation;
    private final double currentQuoteForStock;
    private final double confidenceLevel;

    /**
     * Constructor
     * @param values the collection of historical values for one Stock
     * @throws IllegalArgumentException will rise if some parameters are null or empty array
     */
    public DataExtractor(double[] values) throws IllegalArgumentException{
        this.stock = new Stock(values);
        this.currentQuoteForStock = this.stock.getCurrentQuote();
        this.percentageCalculation = new PercentageCalculation(stock.getHistoricalValues());
        this.deltaCalculation = new CumulatedAverageCalculation(percentageCalculation.getArrayPercentageChangesAcrossHistory());
        this.globalAverageDeltaCalculation = this.deltaCalculation.calculateDelta();
        this.confidenceLevel = Double.parseDouble(PropertiesExtractor.getConfigurationProperty().getProperty(PropertiesExtractor.CONFIDENCE_LEVEL_PROPERTY_NAME));
    }

    /**
     * Get the value of the stock saved
     * @return stock
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * get the percentage of each variation across the history
     * @return double[]
     */
    public PercentageCalculation getPercentageCalculation() {
        return percentageCalculation;
    }

    /**
     * get the delta calculation object
     * @return Delta calculation
     */
    public CumulatedAverageCalculation getDeltaCalculation() {
        return deltaCalculation;
    }

    /**
     * get the global average delta calculation
     * This is the cumulated average of all the delta across history
     * @return double[]
     */
    public double getGlobalAverageDeltaCalculation() {
        return globalAverageDeltaCalculation;
    }

    /**
     * get the current stock quote
     * @return double
     */
    public double getCurrentQuoteForStock() {
        return currentQuoteForStock;
    }

    /**
     * get the confidence level
     * @return double
     */
    public double getConfidenceLevel() {
        return confidenceLevel;
    }
}
