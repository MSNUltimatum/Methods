package company;

import java.util.ArrayList;
import java.util.List;

public class MatrixOperations {
    public static void printMatrix(List<List<Double>> matrix){
        matrix.forEach(e -> {
            e.forEach(l -> System.out.printf("  %s  ", l));
            System.out.println();
        });
        System.out.println();
    }

    public static List<Double> multiplyMatrixToColumn(List<List<Double>> matr1, List<Double> matr2){
        int m = matr1.size();
        int n = matr1.get(0).size();
        int o = matr2.size();
        List<Double> res = new ArrayList<>();

        for (int i = 0; i < matr1.size(); i++) {
            Double result = 0d;
            for (int j = 0; j < matr1.get(i).size(); j++) {
                result += matr1.get(i).get(j) * matr2.get(j);
            }
            res.add(result);
        }
        return res;
    }

    public static List<List<Double>> getMatrix(double num, int n) {
        List<List<Double>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < i; j++) {
                matrix.get(i).add((num + i) / 100);
            }
            matrix.get(i).add(num + i);
            for (int j = 0; j < n - i - 1; j++) {
                matrix.get(i).add((num + i) / 100);
            }
        }
        return matrix;
    }
}
