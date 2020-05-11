package com.yannickfin.var.historical.calculation.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CalculationUtils {

    public static final String FORMAT_WITH_FOUR_DECIMALS = "#.####";

    public static double renderDoubleValueWithRightPrecision(double valueToFormat, String format){
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        DecimalFormat formatter = (DecimalFormat) numberFormat;
        formatter.applyPattern(format);
        return Double.valueOf(formatter.format(valueToFormat));
    }
}
