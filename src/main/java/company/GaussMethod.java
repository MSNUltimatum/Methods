package company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class GaussMethod {
    private  final List<Pair> pairs = new ArrayList<>();
    protected int swapCount = 0;
    public  Double[] gaussMethod(List<List<Double>> matrix){
        directMove(matrix);
        Double[] k = reverseMove(matrix);
        swapResultsVariables(k);
        return k;
    }

    private void swapResultsVariables(Double[] k) {
        Collections.reverse(pairs);
        pairs.forEach(e -> Collections.swap(Arrays.asList(k), (int) e.getFirstValue(), (int) e.getSecondValue()));
    }

    protected  void directMove(List<List<Double>> matrix) {
        int n = matrix.size();
        for (int i = 0; i < n; i++) {
            double a = matrix.get(i).get(i);
            if (a == 0 && i != n - 1) {
                double max = Math.abs(matrix.get(i).get(i));
                int num = i;

                for (int j = i; j < n; j++) {
                    if (Math.abs(matrix.get(j).get(i)) > max) {
                        max = Math.abs(matrix.get(j).get(i));
                        num = j;
                    }
                }
                if (num != i) {
                    swapRows(matrix, n, i, num);
                } else {
                    for (int j = i + 1; j < n; j++) {
                        if(Math.abs(matrix.get(i).get(j)) > max){
                            max = Math.abs(matrix.get(i).get(j));
                            num = j;
                        }
                    }
                    if(num != i){
                        swapColumns(matrix, n, i, num);
                    }
                }

            }
            else {
                divideRowsValues(matrix, n, i, a);
            }

            divideValuesAfterMainDiagonal(matrix, n, i);
        }
    }

    protected void divideValuesAfterMainDiagonal(List<List<Double>> matrix, int n, int i) {
        for (int j = i + 1; j < n; j++) {
            double a2 = matrix.get(j).get(i);
            for (int k = 0; k <= n; k++)
                matrix.get(j).set(k, matrix.get(j).get(k) - matrix.get(i).get(k) * a2);
        }
    }

    private void swapColumns(List<List<Double>> matrix, int n, int i, int num) {
        swapCount++;
        double a;
        pairs.add(new Pair(i, num));
        List<Double> tmp = new ArrayList<>();

        for (List<Double> doubles : matrix) {
            tmp.add(doubles.get(i));
        }

        for (List<Double> doubles : matrix) {
            doubles.set(i, doubles.get(num));
        }

        for (int j = 0; j < n; j++) {
            matrix.get(j).set(num, tmp.get(j));
        }

        a = matrix.get(i).get(i);

        divideRowsValues(matrix, n, i, a);
    }

    protected void divideRowsValues(List<List<Double>> matrix, int n, int i, double a) {
        for (int j = 0; j <= n; j++) {
            matrix.get(i).set(j, matrix.get(i).get(j) / a);
        }
    }

    private void swapRows(List<List<Double>> matrix, int n, int i, int num) {
        swapCount++;
        double a;
        Collections.swap(matrix, i, num);
        a = matrix.get(i).get(i);
        divideRowsValues(matrix, n, i, a);
    }

    protected Double[] reverseMove(List<List<Double>> matrix) {
        int n = matrix.size();
        Double[] k = new Double[n];
        k[n - 1] = matrix.get(n - 1).get(n);
        for (int i = n - 2; i >= 0; i--) {
            k[i] = matrix.get(i).get(n);
            for (int j = i + 1; j < n; j++) {
                k[i] -= matrix.get(i).get(j) * k[j];
            }
        }
        return k;
    }
}
