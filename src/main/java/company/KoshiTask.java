package company;

import java.util.ArrayList;
import java.util.List;

public class KoshiTask {
    private final int v;
    private final double h;
    private final List<List<Double>> answerMatrix = new ArrayList<>();

    public KoshiTask(int v, double h) {
        this.v = v;
        this.h = h;

        for (int i = 0; i < 4; i++) {
            answerMatrix.add(new ArrayList<>());
        }
    }

    public List<List<Double>> eulerMethod(double x0){
        int n = 10;
        double x = x0;
        double y = v;
        for (int i = 0; i < n; i++) {
            fillAnswer(x, y);
            y += h * f(x, y);
            x += h;
        }
        return answerMatrix;

    }

    public List<List<Double>> upgradeEulerMethod(double x0){
        int n = 10;
        double x = x0;
        double y = v;
        for (int i = 0; i < n; i++) {
            fillAnswer(x, y);
            y += h * f(x + h / 2, y + (h / 2) * f(x, y));
            x += h;
        }
        return answerMatrix;
    }

    public List<List<Double>> pkMethod(double x0){
        int n = 10;
        double x = x0;
        double y = v;
        for (int i = 0; i < n; i++) {
            fillAnswer(x, y);
            y += (h / 2) * (f(x, y) + f(x + h, y + h * f(x, y)));
            x += h;
        }
        return answerMatrix;
    }

    private void fillAnswer(double x, double y) {
        double y1 = yFunc(x);
        answerMatrix.get(0).add(x);
        answerMatrix.get(1).add(y);
        answerMatrix.get(2).add(y1);
        answerMatrix.get(3).add(Math.abs(y - y1));
    }

    private double f(double x, double y){
        return 2 * v * x + v * Math.pow(x, 2) - y;
    }

    private double yFunc(double x){
        return v * Math.pow(x, 2);
    }

}
