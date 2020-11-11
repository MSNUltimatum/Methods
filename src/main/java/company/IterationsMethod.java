package company;

import java.util.ArrayList;
import java.util.List;

public class IterationsMethod {
    private final List<List<Double>> matrix;
    private final Double eps;

    public IterationsMethod(List<List<Double>> matrix, Double eps) {
        this.matrix = matrix;
        this.eps = eps;
    }

    public List<Double> start(){
        List<Double> previosVarVals = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            previosVarVals.add(0d);
        }
        while (true){
            List<Double> currentVarVals = new ArrayList<>();
            for (int i = 0; i < matrix.size(); i++) {
                currentVarVals.add(0d);
            }
            for (int i = 0; i < matrix.size(); i++) {
                currentVarVals.set(i, matrix.get(i).get(matrix.size()));
                for (int j = 0; j < matrix.size(); j++) {
                    if (i != j) {
                        currentVarVals.set(i,currentVarVals.get(i) - matrix.get(i).get(j) * previosVarVals.get(j));
                    }
                }
                currentVarVals.set(i, currentVarVals.get(i) / matrix.get(i).get(i));
            }
            double error = 0.0;
            for (int i = 0; i < matrix.size(); i++) {
                error += Math.abs(currentVarVals.get(i) - previosVarVals.get(i));
            }
            if (error < eps) {
                break;
            }
            previosVarVals = currentVarVals;
        }
        return previosVarVals;
    }
}
