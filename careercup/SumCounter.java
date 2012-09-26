/**
 * Solution to "http://www.careercup.com/question?id=11641125" by
 * Fabien Viale
 */
public class SumCounter {
    private int n0;
    private int k0;

    public SumCounter(int n0, int k0) {
        this.n0 = n0;
        this.k0 = k0;
    }

    public int compute() {
       return allsums(n0, k0);
    }

    private int allsums(int n, int k) {
        int max = maxsum(n);
        if (max < k) {
            return 0;
        }
        if (k == n) {
             return 1 + allsums(n-1, k);
        }
        if (k < n) {
           return allsums(k, k);
        }
        return allsums(n-1, k - n) +  allsums(n-1, k);
    }

    public int maxsum(int n) {
        int sum = 0;
        for(int i = 1; i <= n;  i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
         SumCounter sc = new SumCounter(40, 200);
        System.out.println(sc.compute());
    }
}
