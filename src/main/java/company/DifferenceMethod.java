package company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DifferenceMethod {
    private final int v;
    private final double h;

    public DifferenceMethod(int v) {
        this.v = v;
        h = v / 10.0;
    }

    public List<List<Double>> differenceMethod(){
        List<Double> xValues = getXValues();
        List<Double> fValues = getFValues(xValues);
        List<List<Double>> matrix = getMatrixToTridiagonalMethod(xValues);
        List<Double> yValues = getYValues(matrix, fValues);
        List<Double> yExactValues = getExactYValues(xValues);
        return makeAnswerTable(xValues, yValues, yExactValues);
    }

    private List<List<Double>> makeAnswerTable(List<Double> xValues,
                                               List<Double> yValues,
                                               List<Double> yExactValue){
        List<List<Double>> answerMatrix = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            answerMatrix.add(new ArrayList<>());
        }
        yValues.add(0, 0d);
        yValues.add(0d);
        yExactValue.set(yExactValue.size() - 1, 0d);
        xValues.forEach(e -> answerMatrix.get(0).add(e));
        yValues.forEach(e -> answerMatrix.get(1).add(e));
        yExactValue.forEach(e -> answerMatrix.get(2).add(e));
        for (int i = 0; i < yValues.size(); i++) {
            answerMatrix.get(3).add(Math.abs(yValues.get(i) - yExactValue.get(i)));
        }
        return answerMatrix;
    }

    private List<Double> getYValues(List<List<Double>> matrix, List<Double> freeColumn){
        for (int i = 1; i < freeColumn.size() - 1; i++) {
            matrix.get(i - 1).add(freeColumn.get(i));
        }

        return new TridiagonalMatrixMethod(matrix).start();
    }

    private List<List<Double>> getMatrixToTridiagonalMethod(List<Double> xValues) {
        List<List<Double>> matrix = new ArrayList<>();
        for (int i = 0; i < xValues.size() - 2; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < xValues.size() - 2; j++) {
                if (j == i) {
                    matrix.get(i).add(- 2.0 / h / h + xValues.get(i));
                } else if (j == i - 1) {
                    matrix.get(i).add(1.0 / h / h - xValues.get(i) * xValues.get(i) / 2.0 / h);
                } else if (j == i + 1) {
                    matrix.get(i).add(1.0 / h / h + xValues.get(i) * xValues.get(i) / 2.0 / h);
                } else {
                    matrix.get(i).add(0.0);
                }
            }
        }
        return matrix;
    }

    private List<Double> getFValues(List<Double> xValues) {
        List<Double> fValues = new ArrayList<>();
        xValues.forEach(e ->
                fValues.add(Math.pow(e, 4) * v * 4
                - 3 * v * v * Math.pow(e, 3)
                + 6 * v * e
                - 2 * v * v));
        return fValues;
    }

    private List<Double> getXValues() {
        List<Double> xValues = new ArrayList<>();
        xValues.add(0.0);
        for (int i = 1; i < 11; i++) {
            xValues.add(xValues.get(i - 1) + h);
        }
        return xValues;
    }

    private List<Double> getExactYValues(List<Double> xValues){
        return xValues.stream().map(e -> v * Math.pow(e,2) * (e - v)).collect(Collectors.toList());
    }

}
