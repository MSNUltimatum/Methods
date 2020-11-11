import company.Determinant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class DeterminantTest {
    private Determinant determinant;

    @BeforeEach
    private void init(){
        determinant = new Determinant();
    }

    @Test
    public void determinantMatrix4SizeTest(){
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
        Double determinant = this.determinant.getDeterminant(matrix);
        Assertions.assertEquals(-80d, determinant);
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
        Double determinant = this.determinant.getDeterminant(matrix);
        Assertions.assertEquals(69d, determinant);
    }

    @Test
    public void determinantMatrix3SizeTest(){
        List<List<Double>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());
        matrix.add(new ArrayList<>());
        matrix.get(0).add(3d);
        matrix.get(0).add(3d);
        matrix.get(0).add(-1d);
        matrix.get(1).add(4d);
        matrix.get(1).add(1d);
        matrix.get(1).add(3d);
        matrix.get(2).add(1d);
        matrix.get(2).add(-2d);
        matrix.get(2).add(-2d);
        Double determinant = this.determinant.getDeterminant(matrix);
        Assertions.assertEquals(54d, determinant);

    }
}
