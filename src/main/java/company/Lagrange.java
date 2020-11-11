package company;

public class Lagrange extends InterpolientMethods{

    public void lagrangeMethod(int nodeCount) {
        for (Pair pair : pairs) {
            double result = 0;
            for (int j = 0; j < nodeCount; j++) {
                double tmpChis = 1;
                double tmpZnam = 1;
                double tmpResult = nodes.get(j).getSecondValue();
                for (int k = 0; k < nodeCount; k++) {
                    if (k == j)
                        continue;
                    tmpChis *= (pair.getFirstValue() - nodes.get(k).getFirstValue());
                }
                for (int k = 0; k < nodeCount; k++) {
                    if (k == j)
                        continue;
                    tmpZnam *= (nodes.get(j).getFirstValue() - nodes.get(k).getFirstValue());
                }
                result += tmpResult * tmpChis / tmpZnam;
            }
            System.out.printf("L(%.2f) : %f%n", pair.getFirstValue(), result);
        }
    }
}
