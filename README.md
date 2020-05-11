# var-historical-calculation

This library is containing some utilities class to compute a Var based on historical values

## Getting started

### Prerequisites
- You will need a JDK 8
- Maven

### Installing
First is running the test
```
mvn clean test
```
To build the project and generate a jar
```
mvn clean install
```

### Configuration

The confidence level can be configured by creating a file configuration.properties and use the following property
```
confidenceLevel = 0.95
```
if no value, by default 0.95 will be used

### How to use the library
Here is an example (the time unit used is days)
```
double[] historicalValues = {0.58, 0.47, 0.45, 0.68, 0.47}
DataExtractor dataExtractor = new DataExtractor(historicalValues);
List<DataExtractor> dataExtractorList = new ArrayList<>();
dataExtractorList.add(dataExtractor);
RiskPrediction riskPrediction = new HistoricalPrediction(dataExtractorList);
System.out.println(riskPrediction.getValueAtRiskValueFor(0, 1));
```

### Licence

This software is under the property of the author and cannot be reused by any person or organisation without the agreement of the author.
More infomations : 
```
y90.guegan@gmail.com
```


