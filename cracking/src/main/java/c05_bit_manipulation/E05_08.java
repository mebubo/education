package c05_bit_manipulation;

public class E05_08 {

    public static byte[] drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int columns = width / 8;
        int rows = screen.length / columns;
        if (x1 < 0) {
            x1 = 0;
        }
        if (x2 > width - 1) {
            x2 = width - 1;
        }
        int firstByte = y * rows + x1 / 8;
        int firstBit = 7 - x1 % 8;
        int lastByte = y * rows + x2 / 8;
        int lastBit = 7 - x2 % 8;
        if (firstByte == lastByte) {
            screen[firstByte] |= setBits(lastBit, firstBit);
        } else {
            screen[firstByte] |= setBits(0, firstBit);
            screen[lastByte] |= setBits(lastBit, 7);
            for (int i = firstByte + 1; i < lastByte; i++) {
                screen[i] = ~0;
            }
        }
        return screen;
    }

    static byte setBits(int from, int to) {
        return (byte) (~0 << from & ~(~0 << (to + 1)));
    }
}
