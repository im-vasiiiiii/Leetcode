import java.util.*;

class Solution {

    private int rows;
    private int cols;
    private int remaining;
    private HashMap<Integer, Integer> map;
    private Random random;

    public Solution(int m, int n) {
        rows = m;
        cols = n;
        remaining = m * n;
        map = new HashMap<>();
        random = new Random();
    }

    public int[] flip() {
        int r = random.nextInt(remaining);

        int idx = map.getOrDefault(r, r);

        map.put(r, map.getOrDefault(remaining - 1, remaining - 1));

        remaining--;

        return new int[]{idx / cols, idx % cols};
    }

    public void reset() {
        map.clear();
        remaining = rows * cols;
    }
}