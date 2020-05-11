package com.yannickfin.var.historical.calculation.utils;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CalculationUtilsTest {

    @Test
    public void itShouldFormatTheDoubleWithFourDigitsAndRoundItIfTheDoubleInInputIsLonger() {
        double expectedDoubleWithSixDecimals = CalculationUtils.renderDoubleValueWithRightPrecision(0.054787654, CalculationUtils.FORMAT_WITH_FOUR_DECIMALS);

        assertEquals(0.0548, expectedDoubleWithSixDecimals);
    }

    @Test
    public void itShouldKeepTheFormatIfTheDoubleInInputIsShorterThanFourDecimals() {
        double expectedDoubleWithSixDecimals = CalculationUtils.renderDoubleValueWithRightPrecision(0.05, CalculationUtils.FORMAT_WITH_FOUR_DECIMALS);

        assertEquals(0.05, expectedDoubleWithSixDecimals);
    }
}
