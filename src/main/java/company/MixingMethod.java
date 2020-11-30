package company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MixingMethod {
    private final int V = 12;
    private final double T = 1;
    private final double a = 1;
    private final double b = V + 1;
    private final DifferenceMethod differenceMethod;

    public MixingMethod() {
        differenceMethod = new DifferenceMethod(V, 10);
    }

    public List<List<Double>> mixingMethod() {
        int n = 10;
        List<Double> x = Utils.getXValues(0.0, n + 1, 0.1);
        List<Double> f = newFFunction(x, fFunction(x));
        List<List<Double>> matrix = differenceMethod.getMatrixToTridiagonalMethod(x, 0.1);
        List<Double> yValues = differenceMethod.getYValues(matrix, f);
        yValues.add(0, 0.0);
        yValues.add(0.0);
        return Utils.makeAnswerTable(x, getY(x, yValues),getExactYValues(x));
    }

    public double zFunction(double x) {
        return (b - a) / T * x + a;
    }

    public double z1Function() {
        return (b - a) / T;
    }

    public List<Double> getExactYValues(List<Double> x) {
        List<Double> y = new ArrayList<>();
        for (Double xk : x) {
            y.add(V * xk * xk * xk + 1);
        }
        y.set(y.size() - 1, 0d);
        return y;
    }

    public List<Double> fFunction(List<Double> x) {
        List<Double> f = new ArrayList<>();
        for (Double xk : x) {
            f.add(4.0 * V * xk * xk * xk * xk
                    + xk * (6 * V + 1));
        }
        return f;
    }

    public List<Double> newFFunction(List<Double> x, List<Double> f) {
        List<Double> newf = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            double xi = x.get(i);
            newf.add(f.get(i) - Utils.p(xi) * z1Function() - Utils.q(xi) * zFunction(xi));
        }
        return newf;
    }

    public List<Double> getY(List<Double> x, List<Double> y0) {
        List<Double> y = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            double xi = x.get(i);
            y.add(y0.get(i) + zFunction(xi));
        }
        return y;
    }


}
