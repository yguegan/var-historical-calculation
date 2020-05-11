package com.yannickfin.var.historical.calculation;

public interface RiskPrediction {
    double getValueAtRiskValueFor(int indexDataExtractor, int periodUnit);
    double getValueAtRiskValueForPortfolio(int periodUnit);
}
