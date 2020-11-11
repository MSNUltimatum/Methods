import company.TridiagonalMatrixMethod;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTridiagonalMethod {
    @Test
    public void TestTridiagonal(){
        List<List<Double>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());
        matrix.get(0).add(4d);
        matrix.get(0).add(-1d);
        matrix.get(0).add(0d);
        matrix.get(0).add(0d);
        matrix.get(0).add(5d);
        matrix.get(1).add(-1d);
        matrix.get(1).add(4d);
        matrix.get(1).add(-1d);
        matrix.get(1).add(0d);
        matrix.get(1).add(5d);
        matrix.get(2).add(0d);
        matrix.get(2).add(-1d);
        matrix.get(2).add(4d);
        matrix.get(2).add(-1d);
        matrix.get(2).add(10d);
        matrix.get(3).add(0d);
        matrix.get(3).add(0d);
        matrix.get(3).add(-1d);
        matrix.get(3).add(4d);
        matrix.get(3).add(23d);
        List<Double> start = new TridiagonalMatrixMethod(matrix).start();
        System.out.println(start);
    }
}
