package c01_arrays_and_strings;

public class E01_07 {
    public static void zeroCross(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }
        for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (zeroRows[i] || zeroCols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,2,3,4,5},
                {1,2,0,4,5},
                {1,2,3,4,5},
                {1,2,3,4,0},
        };
        zeroCross(matrix);
        E01_06.print(matrix);
    }
}
