import company.TridiagonalMatrixMethod;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestTridiagonalMethod {

    @Test
    public void TestTridiagonal2(){
        List<List<Double>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());
        matrix.get(0).add(2d);
        matrix.get(0).add(-2d);
        matrix.get(0).add(1d);
        matrix.get(0).add(-3d);
        matrix.get(1).add(1d);
        matrix.get(1).add(3d);
        matrix.get(1).add(-2d);
        matrix.get(1).add(1d);
        matrix.get(2).add(3d);
        matrix.get(2).add(-1d);
        matrix.get(2).add(-1d);
        matrix.get(2).add(2d);
        List<Double> start = new TridiagonalMatrixMethod(matrix).start();
        System.out.println(start);
    }
}
