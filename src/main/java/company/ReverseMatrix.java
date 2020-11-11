package company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseMatrix extends GaussMethod{

    public List<List<Double>> findReverseMatrix(List<List<Double>> matrix){
        List<List<Double>> reverseMatrix = new ArrayList<>();
        IntStream.range(0, matrix.size()).forEach(e -> reverseMatrix.add(new ArrayList<>()));
        for (int i = 0; i < matrix.size(); i++) {
            List<List<Double>> copyOfMatrix = new ArrayList<>();
            IntStream.range(0, matrix.size()).forEach(e -> copyOfMatrix.add(new ArrayList<>(matrix.get(e))));
            addFreeColumn(copyOfMatrix, i);
            Double[] doubles = gaussMethod(copyOfMatrix);
            fillJColumnInReverseMatrix(copyOfMatrix, reverseMatrix, doubles);
        }

        return reverseMatrix;
    }

    private void removeFreeColumn(List<List<Double>> matrix) {
        for (int j = 0; j < matrix.size(); j++) {
            matrix.get(j).remove(matrix.size());
        }
    }

    private void fillJColumnInReverseMatrix(List<List<Double>> matrix, List<List<Double>> reverseMatrix, Double[] doubles) {
        for (int j = 0; j < matrix.size(); j++) {
            reverseMatrix.get(j).add(doubles[j]);
        }
    }

    private void addFreeColumn(List<List<Double>> matrix, int i) {
        for (int j = 0; j < matrix.size(); j++) {
            if (j == i) {
                matrix.get(j).add(1d);
            } else {
                matrix.get(j).add(0d);
            }
        }
    }
}
