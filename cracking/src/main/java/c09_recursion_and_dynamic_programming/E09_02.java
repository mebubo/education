package c09_recursion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class E09_02 {
    public static long countRobotPaths(int x, int y) {
        if (x <= 0 || y <= 0) {
            return 0;
        }
        if (x == 1 && y == 1) {
            return 1;
        }
        return countRobotPaths(x - 1, y) + countRobotPaths(x, y - 1);
    }

    public static List<String> findPaths(char[][] map, int x, int y) {
        int height = map.length;
        int width = map[0].length;
        if (x == width - 1 && y == height - 1) {
            return Arrays.asList("");
        }
        ArrayList<String> result = new ArrayList<>();
        if (x + 1 < width && cellIsFree(map, x + 1, y)) {
            result.addAll(prepend("R", findPaths(map, x + 1, y)));
        }
        if (y + 1 < height && cellIsFree(map, x, y + 1)) {
            result.addAll(prepend("D", findPaths(map, x, y + 1)));
        }
        return result;
    }

    private static Collection<? extends String> prepend(String prefix, List<String> paths) {
        return paths.stream().map((String s) -> prefix + s).collect(Collectors.toList());
    }

    private static boolean cellIsFree(char[][] map, int x, int y) {
        return map[y][x] != 'X';
    }


}
