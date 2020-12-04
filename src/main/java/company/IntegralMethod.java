package company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntegralMethod {
    private final Integer V = 12;
    private final List<List<Double>> alphaikValues = new ArrayList<>();
    private final List<Double> yiValues = new ArrayList<>();

    IntegralMethod(){
        fillIntegralMatrix();
        fillyiValues();
    }

    public List<List<Double>> getIntegralTable(){
        List<Double> xValues = getXValues();
        List<Double> qiValues = getQiValues();
        List<Double> yValues = getYValues(xValues, qiValues);
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

    private List<Double> getYValues(List<Double> xValues, List<Double> qiValues){
        List<Double> yValues = new ArrayList<>();
        for (Double x : xValues) {
            double tmp = 0d;
            for (int i = 0; i < 3; i++) {
                tmp += qiValues.get(i) * Math.pow(x, i + 1);
            }
            yValues.add(f(x) - tmp);
        }
        return yValues;
    }

    private List<Double> getQiValues(){
        List<List<Double>> matrixToGauss = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            matrixToGauss.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                matrixToGauss.get(i).add(alphaikValues.get(j).get(i));
            }
            matrixToGauss.get(i).set(i, matrixToGauss.get(i).get(i) + 1);
            matrixToGauss.get(i).add(yiValues.get(i));
        }
        return Arrays.asList(new GaussMethod().gaussMethod(matrixToGauss));
    }

    private List<Double> getXValues(){
        return Utils.getXValues(0, 11, 0.1);
    }

    private Double f(Double x){
        return V * (4d / 3 * x + 1d / 4 * Math.pow(x, 2) + 1d / 5 * Math.pow(x, 3));
    }

    private void fillyiValues() {
        yiValues.add(1969d / 300);
        yiValues.add(5d);
        yiValues.add(283d / 70);
    }

    private void fillIntegralMatrix() {
        alphaikValues.add(new ArrayList<>());
        alphaikValues.add(new ArrayList<>());
        alphaikValues.add(new ArrayList<>());
        alphaikValues.get(0).add((double)1 / 3);
        alphaikValues.get(0).add((double)1 / 4);
        alphaikValues.get(0).add((double)1 / 5);

        alphaikValues.get(1).add((double)1 / 4);
        alphaikValues.get(1).add((double)1 / 5);
        alphaikValues.get(1).add((double)1 / 6);

        alphaikValues.get(2).add((double)1 / 5);
        alphaikValues.get(2).add((double)1 / 6);
        alphaikValues.get(2).add((double)1 / 7);
    }
}
