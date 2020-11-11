package company;

import java.util.List;

public class Determinant extends GaussMethod {
    private Double determinant = 1d;

    public Double getDeterminant(List<List<Double>> matrix){
        directMove(matrix);
        determinant *= Math.pow(-1, swapCount);
        return determinant;
    }

    @Override
    protected void divideRowsValues(List<List<Double>> matrix, int n, int i, double a) {
        determinant *= a;
        for (int j = 0; j < n; j++) {
            matrix.get(i).set(j, matrix.get(i).get(j) / a);
        }
    }

    @Override
    protected void divideValuesAfterMainDiagonal(List<List<Double>> matrix, int n, int i) {
        for (int j = i + 1; j < n; j++) {
            double a2 = matrix.get(j).get(i);
            for (int k = 0; k < n; k++)
                matrix.get(j).set(k, matrix.get(j).get(k) - matrix.get(i).get(k) * a2);
        }
    }
}
