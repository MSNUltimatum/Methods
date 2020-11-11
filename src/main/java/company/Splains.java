package company;

import java.util.ArrayList;
import java.util.List;

import static company.MatrixOperations.printMatrix;
import static java.lang.Math.pow;

public class Splains extends InterpolientMethods{
    
    @Override
    public void start() {
        super.start();
        splines();
    }

    private void splines(){
        int maxVal = nodeCount - 1;
        double[] lengthSplains = new double[maxVal];
        for (int i = 0; i < nodeCount - 1; i++) {
            lengthSplains[i] = nodes.get(i + 1).getFirstValue() - nodes.get(i).getFirstValue();
        }

        List<List<Double>> matrix = new ArrayList<>();
        for (int i = 0; i < maxVal * 4; i++) {
            matrix.add(new ArrayList<>());
        }

        for (int i = 0; i < maxVal; i++) {
            for (int j = 0; j < i * 4; j++) {
                matrix.get(i).add(0.0);
            }
            matrix.get(i).add(1.0);
            for (int j = i * 4 + 1; j < maxVal * 4; j++) {
                matrix.get(i).add(0.0);
            }
            matrix.get(i).add(nodes.get(i).getSecondValue());
        }

        for (int i = 0; i < maxVal; i++) {
            for (int j = 0; j < i * 4; j++) {
                matrix.get(i + maxVal).add(0.0);
            }
            matrix.get(i + maxVal).add(1.0);
            matrix.get(i + maxVal).add(lengthSplains[i]);
            matrix.get(i + maxVal).add(pow(lengthSplains[i], 2));
            matrix.get(i + maxVal).add(pow(lengthSplains[i], 3));
            for (int j = 0; j < maxVal * 4 - ((i + 1) * 4); j++) {
                matrix.get(i + maxVal).add(0.0);
            }
            matrix.get(i + maxVal).add(nodes.get(i + 1).getSecondValue());
        }

        for (int i = 0; i < maxVal - 1; i++) {
            for (int j = 0; j < i * 4 + 1; j++) {
                matrix.get(i + maxVal * 2).add(0.0);
            }
            matrix.get(i + maxVal * 2).add(1.0);
            matrix.get(i + maxVal * 2).add(2 * lengthSplains[i]);
            matrix.get(i + maxVal * 2).add(3 * pow(lengthSplains[i], 2));
            matrix.get(i + maxVal * 2).add(0d);
            matrix.get(i + maxVal * 2).add(-1d);
            for (int j = 0; j < maxVal * 4 - (i * 4 + 6); j++) {
                matrix.get(i + maxVal * 2).add(0.0);
            }
            matrix.get(i + maxVal * 2).add(0d);
        }

        for (int i = 0; i < maxVal - 1; i++) {
            for (int j = 0; j < i * 4 + 2; j++) {
                matrix.get(i + maxVal * 2 + maxVal - 1).add(0d);
            }
            matrix.get(i + maxVal * 2 + maxVal - 1).add(2d);
            matrix.get(i + maxVal * 2 + maxVal - 1).add(6 * lengthSplains[i]);
            matrix.get(i + maxVal * 2 + maxVal - 1).add(0d);
            matrix.get(i + maxVal * 2 + maxVal - 1).add(0d);
            matrix.get(i + maxVal * 2 + maxVal - 1).add(-2d);
            for (int j = 0; j < maxVal * 4 - ((i * 4) + 7); j++) {
                matrix.get(i + maxVal * 2 + maxVal - 1).add(0d);
            }
            matrix.get(i + maxVal * 2 + maxVal - 1).add(0d);
        }
        for (int i = 0; i < 2; i++) {
            matrix.get(maxVal * 2 + (maxVal - 1) * 2).add(0d);
        }
        matrix.get(maxVal * 2 + (maxVal - 1) * 2).add(2d);
        for (int i = 0; i < maxVal * 4 - 3; i++) {
            matrix.get(maxVal * 2 + (maxVal - 1) * 2).add(0d);
        }
        matrix.get(maxVal * 2 + (maxVal - 1) * 2).add(0d);
        for (int i = 0; i < maxVal * 4 - 2; i++) {
            matrix.get(maxVal * 2 + (maxVal - 1) * 2 + 1).add(0d);
        }
        matrix.get(maxVal * 2 + (maxVal - 1) * 2 + 1).add(2d);
        matrix.get(maxVal * 2 + (maxVal - 1) * 2 + 1).add(6 * lengthSplains[lengthSplains.length - 1]);
        matrix.get(maxVal * 2 + (maxVal - 1) * 2 + 1).add(0d);

        printMatrix(matrix);
        Double[] coefs = new GaussMethod().gaussMethod(matrix);

        for (int i = 0, p = 0; i < pairs.size(); i++, p += 4) {
            double mul = pairs.get(i).getFirstValue() - nodes.get(i).getFirstValue();
            double Si = coefs[p]
                    + coefs[p + 1] * mul
                    + coefs[p + 2] * pow(mul, 2)
                    + coefs[p + 3] * pow(mul, 3);
            System.out.printf("%s : %s\n", pairs.get(i).getFirstValue(), Si);
        }
    }
}
