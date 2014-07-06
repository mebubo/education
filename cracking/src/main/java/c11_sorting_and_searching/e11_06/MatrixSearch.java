package c11_sorting_and_searching.e11_06;

public class MatrixSearch {
    public static Coordinate searchInMatrixWithSortedRowsAndColumns(int[][] matrix, int x) {
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == x) {
                return new Coordinate(column, row);
            }
            if (matrix[row][column] < x) {
                row++;
            } else {
                column--;
            }
        }
        return null;
    }
}
