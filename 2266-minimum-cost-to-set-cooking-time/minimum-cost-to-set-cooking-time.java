class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int ans = Integer.MAX_VALUE;

        // Try two possible representations
        int m = targetSeconds / 60;
        int s = targetSeconds % 60;

        ans = Math.min(ans, calcCost(startAt, moveCost, pushCost, m, s));

        if (m > 0 && s + 60 <= 99) {
            ans = Math.min(ans, calcCost(startAt, moveCost, pushCost, m - 1, s + 60));
        }

        return ans;
    }

    private int calcCost(int startAt, int moveCost, int pushCost, int m, int s) {
        if (m > 99 || s > 99) return Integer.MAX_VALUE;

        String str = String.format("%02d%02d", m, s);

        // Remove leading zeros
        int idx = 0;
        while (idx < 3 && str.charAt(idx) == '0') idx++;
        str = str.substring(idx);

        int finger = startAt;
        int cost = 0;
        for (char c : str.toCharArray()) {
            int digit = c - '0';
            if (finger == digit) {
                cost += pushCost;
            } else {
                cost += moveCost + pushCost;
                finger = digit;
            }
        }
        return cost;
    }
}

