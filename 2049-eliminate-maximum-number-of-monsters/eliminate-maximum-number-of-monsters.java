import java.util.Arrays;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {

        int n = dist.length;
        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = (dist[i] - 1) / speed[i];
        }

        Arrays.sort(time);

        for (int minute = 0; minute < n; minute++) {
            if (time[minute] < minute) {
                return minute;
            }
        }

        return n;
    }
}