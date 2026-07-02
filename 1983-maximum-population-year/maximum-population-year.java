class Solution {
    public int maximumPopulation(int[][] logs) {

        int[] diff = new int[101];

        for (int[] log : logs) {
            diff[log[0] - 1950]++;
            diff[log[1] - 1950]--;
        }

        int maxPop = 0;
        int currPop = 0;
        int answer = 1950;

        for (int i = 0; i < 101; i++) {
            currPop += diff[i];

            if (currPop > maxPop) {
                maxPop = currPop;
                answer = 1950 + i;
            }
        }

        return answer;
    }
}