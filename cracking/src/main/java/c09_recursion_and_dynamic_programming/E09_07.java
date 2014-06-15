package c09_recursion_and_dynamic_programming;

public class E09_07 {

    public static void paintFill(char[][] screen, int x, int y, char newColor) {
        paintFillHelper(screen, x, y, newColor, screen[y][x]);
    }

    private static void paintFillHelper(char[][] screen, int x, int y, char newColor, char oldColor) {
        int height = screen.length;
        int width = screen[0].length;
        if (x < 0 || y < 0 || x >= width || y >= height || screen[y][x] != oldColor) {
            return;
        }
        screen[y][x] = newColor;
        paintFillHelper(screen, x + 1, y, newColor, oldColor);
        paintFillHelper(screen, x - 1, y, newColor, oldColor);
        paintFillHelper(screen, x, y + 1, newColor, oldColor);
        paintFillHelper(screen, x, y - 1, newColor, oldColor);

    }
}
