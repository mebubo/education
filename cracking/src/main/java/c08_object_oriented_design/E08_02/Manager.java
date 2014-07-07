package c08_object_oriented_design.E08_02;

public class Manager extends Employee {
    public Manager() {
        this(0);
    }

    public Manager(int i) {
        super(i);
        rank = Rank.Manager;
    }
}
