class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];

        // Count people of each age
        for (int age : ages) {
            count[age]++;
        }

        int ans = 0;

        for (int ageX = 1; ageX <= 120; ageX++) {
            if (count[ageX] == 0) continue;

            for (int ageY = 1; ageY <= 120; ageY++) {
                if (count[ageY] == 0) continue;

                if (ageY <= ageX / 2.0 + 7) continue;
                if (ageY > ageX) continue;

                if (ageX == ageY) {
                    ans += count[ageX] * (count[ageX] - 1);
                } else {
                    ans += count[ageX] * count[ageY];
                }
            }
        }

        return ans;
    }
}