package company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class InterpolientMethods {
    protected List<Pair> nodes = new ArrayList<>();
    protected List<Pair> pairs = new ArrayList<>();
    protected int nodeCount = 0;

    protected void start(){
        Scanner sc = new Scanner(System.in);
        nodeCount = sc.nextInt();
        fillNodes(sc, nodeCount, nodes);
        fillPairs(nodes, pairs);
    }

    protected void fillPairs(List<Pair> nodes, List<Pair> pairs) {
        for (int i = 0; i < nodes.size() - 1; i++) {
            pairs.add(new Pair((nodes.get(i).getFirstValue() + nodes.get(i + 1).getFirstValue()) / 2, Integer.MAX_VALUE));
        }
    }

    protected void fillNodes(Scanner sc, int nodeCount, List<Pair> nodes) {
        for (int i = 0; i < nodeCount; i++) {
            System.out.println("Write next node like (node, weight): ");
            double node = sc.nextDouble();
            double value = sc.nextDouble();
            nodes.add(new Pair(node, value));
        }
    }
}
