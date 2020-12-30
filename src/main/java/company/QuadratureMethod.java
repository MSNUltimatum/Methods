package company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadratureMethod {
    private final Integer V = 4;
    private final Double h = 0.1;

    QuadratureMethod(){

    }

    public List<List<Double>> quadratureMethod(){
        List<Double> xValues = getXValues();
        List<Double> yValues = getYValues(xValues);
        List<Double> extractYValues = getExtractYValues(xValues);
        return Utils.makeAnswerTable(xValues, yValues, extractYValues);
    }

    private List<Double> getExtractYValues(List<Double> xValues){
        List<Double> extractYValues = new ArrayList<>();
        for (Double xValue : xValues) {
            extractYValues.add(xValue * V);
        }
        return extractYValues;
    }

    private List<Double> getYValues(List<Double> xValues){
        List<Double> ykValues = getYkValues(xValues);
        List<Double> yValues = new ArrayList<>();
        for (int i = 0; i < xValues.size(); i++) {
            double sum = 0;
            for (int k = 0; k < xValues.size(); k++) {
                sum += h * A(xValues.get(i), xValues.get(k)) * ykValues.get(k);
            }
            yValues.add(f(xValues.get(i)) - sum);
        }
        return yValues;
    }

    private List<Double> getXValues(){
        return Utils.getXValues(0.1, 10, 0.1);
    }

    private List<Double> getYkValues(List<Double> xValues){
        List<List<Double>> matrixToGauss = new ArrayList<>();
        for (int k = 0; k < xValues.size(); k++) {
            matrixToGauss.add(new ArrayList<>());
            for (int j = 0; j < xValues.size(); j++) {
                matrixToGauss.get(k).add(h * A(xValues.get(k), xValues.get(j)));
            }
            matrixToGauss.get(k).set(k, matrixToGauss.get(k).get(k) + 1);
            matrixToGauss.get(k).add(f(xValues.get(k)));
        }
        Double[] doubles = new GaussMethod().gaussMethod(matrixToGauss);
        return new ArrayList<>(Arrays.asList(doubles));
    }


    private Double A(double x, double t){
        return x * t + x * x * t * t + x * x * x * t * t * t;
    }

    private Double f(Double x){
        return V * (4.0 / 3.0 * x + 0.25 * x * x + 0.2 * x * x * x);
    }
}
