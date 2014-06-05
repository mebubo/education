package c05_bit_manipulation;

public class E05_02 {

    public static String toBinary(double x) {
        String result = "";
        for (int i = 0; i < 32; i++) {
            if (x >= 1) {
                result += "1";
                x -= 1;
            } else {
                result += "0";
            }
            if (i == 0) {
                result += ".";
            }
            if (x == 0) {
                break;
            }
            x *= 2;
        }
        if (x != 0) {
            return "ERROR";
        }
        return result;
    }
}
