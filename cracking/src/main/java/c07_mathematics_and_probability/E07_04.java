package c07_mathematics_and_probability;

public class E07_04 {

    public static int subtract(int a, int b) {
        return a + negate(b);
    }

    private static int negate(int a) {
        int result = 0;
        int diff = a < 0 ? 1 : -1;
        while (a != 0) {
            a += diff;
            result += diff;
        }
        return result;
    }

    private static int abs(int a) {
        if (a < 0) {
            return negate(a);
        } else {
            return a;
        }
    }

    public static int multiply(int a, int b) {
        int result = 0;
        for (int i = 0; i < abs(b); i++) {
            result += a;
        }
        if (b < 0) {
            result = negate(result);
        }
        return result;
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by 0");
        }
        int sign = 1;
        if (a < 0) {
            a = negate(a);
            sign = negate(sign);
        }
        if (b < 0) {
            b = negate(b);
            sign = negate(sign);
        }
        int result = 0;
        int grow = b;
        while (grow <= a) {
            grow += b;
            result += 1;
        }
        return multiply(sign, result);
    }
}
