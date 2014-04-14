package c01_arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;

public class E01_06 {
    public static void rotate(int[][] input) {
        rotate(input, 0, input.length);
    }

    private static void rotate(int[][] input, int start, int size) {
        if (size == 0 || size == 1) {
            return;
        }
        int stop = start + size - 1;
        for (int i = 1; i < size; i++) {
            int tmp = input[start + i][start];
            input[start + i][start] = input[start][stop - i];
            input[start][stop - i] = input[stop - i][stop];
            input[stop - i][stop] = input[stop][start + i];
            input[stop][start + i] = tmp;
        }
        rotate(input, start + 1, size - 2);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5},
        };
        print(input);
        rotate(input);
        print(input);
    }

    public static void print(int[][] input) {
        for (int[] row : input) {
            ArrayList<Integer> rowList = new ArrayList<>();
            for (Integer i :row) {
                rowList.add(i);
            }
            System.out.println(rowList);
        }
        System.out.println();
    }
}