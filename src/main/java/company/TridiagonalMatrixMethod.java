package company;


import java.util.ArrayList;
import java.util.List;

public class TridiagonalMatrixMethod {
    private final List<Double> ADiagonal = new ArrayList<>();
    private final List<Double> BDiagonal = new ArrayList<>();
    private final List<Double> CDiagonal = new ArrayList<>();
    private final List<Double> FreeColumn = new ArrayList<>();

    public TridiagonalMatrixMethod(List<List<Double>> matrix){
        init(matrix);
    }

    public List<Double> start(){
        TridiagonalAlgorithm();
        return FreeColumn;
    }

    private void init(List<List<Double>> matrix){
        if(matrix != null){
            for (int i = 0; i < matrix.size(); i++) {
                if(i != 0){
                    ADiagonal.add(matrix.get(i).get(i - 1));
                } else {
                    ADiagonal.add(0d);
                }
                BDiagonal.add(matrix.get(i).get(i));
                if(i != matrix.size() - 1){
                    CDiagonal.add(matrix.get(i).get(i + 1));
                } else {
                    CDiagonal.add(0d);
                }
//                if(Math.abs(BDiagonal.get(i)) <= Math.abs(ADiagonal.get(i)) + Math.abs(CDiagonal.get(i))){
//                    throw new IllegalStateException("Matrix is not allowed");
//                }
                FreeColumn.add(matrix.get(i).get(matrix.get(i).size() - 1));
            }
        } else {
            throw new IllegalStateException("Empty matrix");
        }
    }

    private void TridiagonalAlgorithm() {
        int n = ADiagonal.size() - 1;
        CDiagonal.set(0, CDiagonal.get(0) / BDiagonal.get(0));
        FreeColumn.set(0, FreeColumn.get(0) / BDiagonal.get(0));

        for (int i = 1; i < n; i++) {
            CDiagonal.set(i, CDiagonal.get(i) / (BDiagonal.get(i) - ADiagonal.get(i) * CDiagonal.get(i-1)));
            FreeColumn.set(i, (FreeColumn.get(i) - ADiagonal.get(i) * FreeColumn.get(i-1)) /
                              (BDiagonal.get(i) - ADiagonal.get(i) * CDiagonal.get(i-1)));
        }

        FreeColumn.set(n, (FreeColumn.get(n) - ADiagonal.get(n) * FreeColumn.get(n-1)) /
                (BDiagonal.get(n) - ADiagonal.get(n) * CDiagonal.get(n-1)));

        for (int i = n; i-- > 0;) {
            FreeColumn.set(i, FreeColumn.get(i) - CDiagonal.get(i) * FreeColumn.get(i+1));
        }
    }
}
