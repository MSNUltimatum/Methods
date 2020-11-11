package company;

import java.util.ArrayList;
import java.util.List;

import static company.MatrixOperations.printMatrix;

public class Newthon extends InterpolientMethods {

    public void newthonMethod(int nodesCount){
        List<List<Double>> matrix = new ArrayList<>();
        for (int i = 0; i < nodesCount; i++) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < nodesCount; i++) {
            for (int j = 0; j < nodesCount; j++) {
                if(i == 0)
                    matrix.get(i).add(nodes.get(j).getSecondValue());
                else {
                    if(j < nodesCount - i)
                        matrix.get(i).add((matrix.get(i - 1).get(j + 1) - matrix.get(i - 1).get(j)) /
                                (nodes.get(j + i).getFirstValue() - nodes.get(j).getFirstValue()));
                }
            }
        }
        printMatrix(matrix);

        for (Pair pair: pairs) {
            double result = 0;
            for (int i = 0; i < nodesCount; i++) {
                double tmp = matrix.get(i).get(0);
                for (int j = 0; j < i; j++) {
                    tmp *= (pair.getFirstValue() - nodes.get(j).getFirstValue());
                }
                result += tmp;
            }
            System.out.printf("L(%.2f) : %f%n", pair.getFirstValue(), result);
        }
    }
}
