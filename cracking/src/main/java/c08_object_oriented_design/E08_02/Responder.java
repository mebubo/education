package c08_object_oriented_design.E08_02;

public class Responder extends Employee {
    public Responder() {
        this(0);
    }

    public Responder(int i) {
        super(i);
        rank = Rank.Responder;
    }
}
