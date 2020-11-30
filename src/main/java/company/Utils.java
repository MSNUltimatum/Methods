package company;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Double> getXValues(double x0, double bound, double delta) {
        List<Double> x = new ArrayList<>();
        double xk = x0;
        for (int i = 1; i <= bound; i++) {
            x.add(xk);
            xk += delta;
        }
        return x;
    }

    public static List<List<Double>> makeAnswerTable(List<Double> xValues,
                                              List<Double> yValues,
                                              List<Double> yExactValue){
        List<List<Double>> answerMatrix = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            answerMatrix.add(new ArrayList<>());
        }
        xValues.forEach(e -> answerMatrix.get(0).add(e));
        yValues.forEach(e -> answerMatrix.get(1).add(e));
        yExactValue.forEach(e -> answerMatrix.get(2).add(e));
        for (int i = 0; i < yValues.size(); i++) {
            answerMatrix.get(3).add(Math.abs(yValues.get(i) - yExactValue.get(i)));
        }
        return answerMatrix;
    }

    public static Double p(double x){
        return x * x;
    }
    public static Double q(double x){
        return x;
    }
}
