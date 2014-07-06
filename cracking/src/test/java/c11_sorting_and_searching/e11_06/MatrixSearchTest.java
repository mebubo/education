package c11_sorting_and_searching.e11_06;

import org.junit.Test;

import static c11_sorting_and_searching.e11_06.MatrixSearch.searchInMatrixWithSortedRowsAndColumns;
import static org.junit.Assert.*;

public class MatrixSearchTest {

    @Test
    public void testSearchInMatrixWithSortedRowsAndColumns() throws Exception {
        int[][] matrix = {
                new int[]{15, 20, 40, 85},
                new int[]{20, 35, 80, 95},
                new int[]{30, 55, 95, 105},
                new int[]{40, 80, 100, 120}
        };
        assertEquals(new Coordinate(1, 2), searchInMatrixWithSortedRowsAndColumns(matrix, 55));
        assertEquals(new Coordinate(0, 0), searchInMatrixWithSortedRowsAndColumns(matrix, 15));
        assertNull(searchInMatrixWithSortedRowsAndColumns(matrix, 1));
    }
}