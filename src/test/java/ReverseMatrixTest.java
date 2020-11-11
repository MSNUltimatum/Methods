import company.ReverseMatrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseMatrixTest {
    private ReverseMatrix reverseMatrix;

    @BeforeEach
    private void init(){
        reverseMatrix = new ReverseMatrix();
    }
    @Test
    public void reverseMatrixTest(){
        List<List<Double>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());
        matrix.get(0).add(-2d);
        matrix.get(0).add(1d);
        matrix.get(0).add(3d);
        matrix.get(0).add(2d);
        matrix.get(1).add(3d);
        matrix.get(1).add(0d);
        matrix.get(1).add(-1d);
        matrix.get(1).add(2d);
        matrix.get(2).add(-5d);
        matrix.get(2).add(2d);
        matrix.get(2).add(3d);
        matrix.get(2).add(0d);
        matrix.get(3).add(4d);
        matrix.get(3).add(-1d);
        matrix.get(3).add(2d);
        matrix.get(3).add(-3d);
        List<List<Double>> reverseMatrix = this.reverseMatrix.findReverseMatrix(matrix);
        printMatrix(matrix);
        printMatrix(reverseMatrix);
        printMatrix(multiplyMatrix(reverseMatrix, matrix));
    }

    @Test
    public void determinantMatrix2SizeTest(){
        List<List<Double>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());
        matrix.get(0).add(11d);
        matrix.get(0).add(-2d);
        matrix.get(1).add(7d);
        matrix.get(1).add(5d);
        List<List<Double>> reverseMatrix = this.reverseMatrix.findReverseMatrix(matrix);
        printMatrix(matrix);
        printMatrix(reverseMatrix);
        printMatrix(multiplyMatrix(reverseMatrix, matrix));
    }

    private List<List<Double>> multiplyMatrix(List<List<Double>> matrix1, List<List<Double>> matrix2){
        List<List<Double>> resultMatrix = new ArrayList<>();
        IntStream.range(0, matrix1.size()).forEach(e -> resultMatrix.add(new ArrayList<>()));
        for (int i = 0; i < matrix1.size(); i++) {
            for (int j = 0; j < matrix1.size(); j++) {
                double tmp = 0;
                for (int k = 0; k < matrix2.size(); k++) {
                    tmp += matrix1.get(i).get(k) * matrix2.get(k).get(j);
                }
                resultMatrix.get(i).add(tmp);
            }
        }

        return resultMatrix;
    }

    protected static void printMatrix(List<List<Double>> matrix){
        matrix.forEach(e -> {
            e.forEach(l -> System.out.printf("  %.2f  ", l));
            System.out.println();
        });
        System.out.println();
    }
}
