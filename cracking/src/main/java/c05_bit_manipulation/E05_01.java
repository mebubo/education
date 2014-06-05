package c05_bit_manipulation;

public class E05_01 {

    public static int insert(int n, int m, int i, int j) {
        int n_cleared = clear(n, i, j);
        int m_shifted = m << i;
        return n_cleared | m_shifted;
    }

    private static int clear(int n, int i, int j) {
        for (int k = i; k <= j; k++) {
            n &= ~(1 << k);
        }
        return n;
    }
}
