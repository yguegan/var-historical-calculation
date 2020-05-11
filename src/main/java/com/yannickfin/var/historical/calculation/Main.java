package com.yannickfin.var.historical.calculation;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        double[] historicalValues = new double[args.length-1];
        for(int indexArguments = 1; indexArguments < args.length; indexArguments++){
            historicalValues[indexArguments - 1] = Double.parseDouble(args[indexArguments]);
        }
        DataExtractor dataExtractor = new DataExtractor(historicalValues);
        List<DataExtractor> dataExtractorList = new ArrayList<>();
        dataExtractorList.add(dataExtractor);
        RiskPrediction riskPrediction = new HistoricalPrediction(dataExtractorList);
        System.out.println(riskPrediction.getValueAtRiskValueFor(0, 1));
    }
}
