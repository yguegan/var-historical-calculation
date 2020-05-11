package com.yannickfin.var.historical.calculation;

import com.yannickfin.var.historical.calculation.utils.PropertiesExtractor;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DataExtractorTest {

    private DataExtractor testDataExtractor;

    private final double[] mockHistoricalValues = {0.5, 0.3, 0.7};

    @Before
    public void initialiseDataExtractor() {
        testDataExtractor = new DataExtractor(mockHistoricalValues);
    }

    @Test(expected=IllegalArgumentException.class)
    public void itShouldThrowsAnExceptionIfTheInputValueIsNull() {
        testDataExtractor = new DataExtractor(null);
    }

    @Test
    public void itShouldInitialiseAStockWithTheValuesSent() throws IllegalArgumentException {
        Stock expectedStockCreated = new Stock(mockHistoricalValues);

        assertEquals(expectedStockCreated, testDataExtractor.getStock());
    }

    @Test
    public void itShouldInitialiseCurrentQuoteForStockWithTheCurrentQuoteOfTheStock() throws IllegalArgumentException {
        Stock expectedStockCreated = new Stock(mockHistoricalValues);

        assertEquals(expectedStockCreated.getCurrentQuote(), testDataExtractor.getCurrentQuoteForStock());
    }

    @Test
    public void itShouldInitialisePercentageCalculationBasedOnTheStockValuesSent() {
        PercentageCalculation expectedPercentageCalculation = new PercentageCalculation(mockHistoricalValues);

        assertEquals(expectedPercentageCalculation, testDataExtractor.getPercentageCalculation());
    }

    @Test
    public void itShouldInitialiseDeltaCalculationBasedOnTheGeneratedPercentageObject() {
        PercentageCalculation expectedPercentageCalculation = new PercentageCalculation(mockHistoricalValues);
        CumulatedAverageCalculation expectedCumulatedAverageCalculation = new CumulatedAverageCalculation(expectedPercentageCalculation.getArrayPercentageChangesAcrossHistory());

        assertEquals(expectedCumulatedAverageCalculation, testDataExtractor.getDeltaCalculation());
    }

    @Test
    public void itShouldInitialiseGlobalAverageDeltaCalculationBasedOnAverageOfCumulatedAverage() {
        PercentageCalculation expectedPercentageCalculation = new PercentageCalculation(mockHistoricalValues);
        CumulatedAverageCalculation expectedCumulatedAverageCalculation = new CumulatedAverageCalculation(expectedPercentageCalculation.getArrayPercentageChangesAcrossHistory());

        assertEquals(expectedCumulatedAverageCalculation.calculateDelta(), testDataExtractor.getGlobalAverageDeltaCalculation());
    }

    @Test
    public void itShouldInitialiseConfidenceLevelWithThePropertyValue() {
        assertEquals(Double.valueOf(PropertiesExtractor.getConfigurationProperty().getProperty(PropertiesExtractor.CONFIDENCE_LEVEL_PROPERTY_NAME)), testDataExtractor.getConfidenceLevel());
    }
}
