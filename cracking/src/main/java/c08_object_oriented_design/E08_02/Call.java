package c08_object_oriented_design.E08_02;

import java.util.Random;

public class Call {

    private static int numInstances;
    private int number = numInstances++;

    private String phoneNumber = String.valueOf(new Random().nextInt(10000000));
    private Rank rank = Rank.Responder;

    public void incrementRank() {
        rank = rank.nextRank();
    }

    public void end() {

    }

    public void fail() {

    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return "Call{" +
                "number=" + number +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", rank=" + rank +
                '}';
    }

}
