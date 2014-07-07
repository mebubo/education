package c08_object_oriented_design.E08_02;

public class Director extends Employee {
    public Director() {
        this(0);
    }

    public Director(int i) {
        super(i);
        rank = Rank.Director;
    }
}
