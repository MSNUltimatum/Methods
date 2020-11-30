package company;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UndefinedCoefficientMethod {
    private final double h;
    private final double T;
    private final double n;
    UndefinedCoefficientMethod(double v){
        T = v;
        h = v / 10;
        n = 10;
    }

    public List<List<Double>> undefinedCoefficientMethod(){
        List<Double> xValues = Utils.getXValues(h, n, h);
        List<List<Double>> slau = SLAU(xValues);
        List<Double> slauSolution = getSLAUSolution(slau, fFunction(xValues));
        return Utils.makeAnswerTable(xValues, getYFunction(slauSolution, xValues), getExactYValues(xValues));
    }

    private List<List<Double>> SLAU(List<Double> xValues){
        List<List<Double>> slauMatrix = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            slauMatrix.add(new ArrayList<>());
            double xj = xValues.get(i - 1);
            for (int k = 1; k <= n; k++) {
                slauMatrix.get(i - 1).add(getFiDerived2(xj, k)
                        + Utils.p(xj) * getFiDerived1(xj, k)
                        + Utils.q(xj) * getFiFunction(xj, k));
            }
        }
        return slauMatrix;
    }

    private double getFiFunction(double xj, int k){
        return Math.pow(xj, k) * (xj - T);
    }

    private double getFiDerived1(double xj, int k){
        return Math.pow(xj, k - 1) * k * (xj - T) + Math.pow(xj, k);
    }

    private double getFiDerived2(double xj, int k){
       return k * T * Math.pow(xj, k - 2) + k * Math.pow(xj, k - 1) - k * k * Math.pow(xj , k - 2) * (T - xj);
    }


    private List<Double> fFunction(List<Double> x) {
        List<Double> fColumn = new ArrayList<>();
        for (Double xk : x) {
            fColumn.add(4.0 * T * Math.pow(xk, 4)
                    - 3.0 * T * T * Math.pow(xk, 3)
                    + 6.0 * T * xk
                    - 2.0 * T * T);
        }
        return fColumn;
    }

    private List<Double> getSLAUSolution(List<List<Double>> SLAU, List<Double> freeColumn){
        for (int i = 0; i < freeColumn.size(); i++) {
            SLAU.get(i).add(freeColumn.get(i));
        }
        return Arrays.asList(new GaussMethod().gaussMethod(SLAU));
    }

    private List<Double> getExactYValues(List<Double> xValues) {
        List<Double> y = new ArrayList<>();
        for (Double xk : xValues) {
            y.add(T * xk * xk * (xk - T));
        }
        return y;
    }

    private List<Double> getYFunction(List<Double> slauSolution, List<Double> xValues) {
        ArrayList<Double> y = new ArrayList<>();
        for (double xk : xValues) {
            double yk = 0.0;
            for (int k = 1; k <= n; k++) {
                yk += slauSolution.get(k - 1) * getFiFunction(xk, k);
            }
            y.add(yk);
        }
        return y;
    }

}
