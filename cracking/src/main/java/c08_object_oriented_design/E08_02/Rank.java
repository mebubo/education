package c08_object_oriented_design.E08_02;

public enum Rank {
    Responder, Manager, Director;

    public Rank nextRank() {
        switch (this) {
            case Responder:
                return Manager;
            case Manager:
                return Director;
            case Director:
                return Director;
            default:
                throw new IllegalArgumentException();
        }
    }
}
