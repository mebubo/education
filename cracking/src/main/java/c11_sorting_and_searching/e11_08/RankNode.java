package c11_sorting_and_searching.e11_08;

public class RankNode {
    private final int data;
    private RankNode left;
    private RankNode right;
    private int leftCount = 1;

    public RankNode(int data) {
        this.data = data;
    }

    public void insert(int data) {
        if (data == this.data) {
            leftCount++;
            return;
        }
        if (data < this.data) {
            if (left == null) {
                left = new RankNode(data);
            } else {
                left.insert(data);
            }
            leftCount++;
        } else {
            if (right == null) {
                right = new RankNode(data);
            } else {
                right.insert(data);
            }
        }
    }

    public int getRankOfNumber(int i) {
        if (data == i) {
            return leftCount;
        } else if (i < data) {
            if (left == null) {
                return -1;
            } else {
                return left.getRankOfNumber(i);
            }
        } else {
            if (right == null) {
                return -1;
            } else {
                int rank = right.getRankOfNumber(i);
                if (rank == -1) {
                    return -1;
                } else {
                    return leftCount + rank;
                }
            }
        }
    }
}
