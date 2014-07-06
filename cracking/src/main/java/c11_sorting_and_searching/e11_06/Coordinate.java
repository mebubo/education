package c11_sorting_and_searching.e11_06;

public class Coordinate {
    int column;
    int row;

    public Coordinate(int column, int row) {
        this.column = column;
        this.row = row;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinate that = (Coordinate) o;

        if (column != that.column) return false;
        if (row != that.row) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = column;
        result = 31 * result + row;
        return result;
    }

}
