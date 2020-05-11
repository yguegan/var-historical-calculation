package com.yannickfin.var.historical.calculation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HistoricalPredictionTest {

    private HistoricalPrediction testHistoricalPrediction;

    @Before
    public void initialiseHistoricalPrediction() {
        DataExtractor mockDataExtractor = mock(DataExtractor.class);
        when(mockDataExtractor.getGlobalAverageDeltaCalculation()).thenReturn(0.3);
        when(mockDataExtractor.getCurrentQuoteForStock()).thenReturn(0.54785478);
        when(mockDataExtractor.getConfidenceLevel()).thenReturn(0.95);

        List<DataExtractor> listDataExtractor = new ArrayList<>();
        listDataExtractor.add(mockDataExtractor);
        listDataExtractor.add(mockDataExtractor);

        testHistoricalPrediction = new HistoricalPrediction(listDataExtractor);
    }

    @Test
    public void itReturnTheValueAtRiskWithFourDecimalForOneDay() {
        double expectedValueAtRisk = 0.1561;

        double valueAtRisk = testHistoricalPrediction.getValueAtRiskValueFor(0, 1);

        assertEquals(expectedValueAtRisk, valueAtRisk);
    }

    @Test
    public void itReturnTheValueAtRiskFOrThePortfolioForOneDay() {
        double expectedValueAtRisk = 0.3122;

        double valueAtRisk = testHistoricalPrediction.getValueAtRiskValueForPortfolio(1);

        assertEquals(expectedValueAtRisk, valueAtRisk);
    }
}
