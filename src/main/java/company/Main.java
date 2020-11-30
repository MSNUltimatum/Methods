package company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static company.MatrixOperations.*;

public class Main {

    public static void main(String[] args) {
        List<List<Double>> matrix = new UndefinedCoefficientMethod(12).undefinedCoefficientMethod();
        printMatrix(matrix);
    }

    private static void testMaxReverseMatrix(){
        double num = 12.0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ReverseMatrix reverseMatrix = new ReverseMatrix();
        List<List<Double>> matrix = getMatrix(num, n);
        reverseMatrix.findReverseMatrix(matrix);
    }

    private static void testGauss() {
        double num = 12.0;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        List<List<Double>> matrix = getMatrix(num, n);

        List<Double> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(num + i);
        }

        List<Double> multMatr = multiplyMatrixToColumn(matrix, nums);
        for (int i = 0; i < n; i++) {
            matrix.get(i).add(multMatr.get(i));
        }

        List<Double> start = new IterationsMethod(matrix, 0.000001).start();
        System.out.println(start);
//        Double[] doubles = new GaussMethod().gaussMethod(matrix);
//        Arrays.stream(doubles).forEach(e -> System.out.printf("%.2f\n", e));
    }


}
