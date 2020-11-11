package company;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.pow;

public class FirstMethod extends InterpolientMethods {

    @Override
    public void start() {
        super.start();
        firstMethod();
    }

    private void firstMethod(){
        List<List<Double>> matrixOfCoffs = new ArrayList<>();
        fillMatrixOfCoefs(nodeCount, nodes, matrixOfCoffs);
        Double[] doubles = new GaussMethod().gaussMethod(matrixOfCoffs);
        for (int i = 0; i < pairs.size(); i++) {
            double sum = 0;
            for (int j = 0; j < doubles.length; j++) {
                sum += doubles[doubles.length - 1 - j] * pow(pairs.get(i).getFirstValue(), j);
            }
            System.out.printf("%s : %s\n", pairs.get(i).getFirstValue(), sum);
        }
    }

    private static void fillMatrixOfCoefs(int nodeCount, List<Pair> nodes, List<List<Double>> matrixOfCoffs) {
        for (int i = 0; i < nodes.size(); i++) {
            matrixOfCoffs.add(new ArrayList<>());
            for (int j = 0; j < nodes.size(); j++) {
                matrixOfCoffs.get(i).add(pow(nodes.get(i).getFirstValue(), nodeCount - 1 - j));
            }
            matrixOfCoffs.get(i).add(nodes.get(i).getSecondValue());
        }
    }
}
