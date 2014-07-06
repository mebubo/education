package c11_sorting_and_searching.e11_08;

public class Tracking {

    private RankNode tree;

    public void track(int i) {
        if (tree == null) {
            tree = new RankNode(i);
        } else {
            tree.insert(i);
        }
    }

    public int getRankOfNumber(int i) {
        if (tree == null) {
            return -1;
        } else {
            return tree.getRankOfNumber(i);
        }
    }
}
