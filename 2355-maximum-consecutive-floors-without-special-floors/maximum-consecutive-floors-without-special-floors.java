import java.util.*;

class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int maxGap = 0;

        // Gap before the first special floor
        maxGap = Math.max(maxGap, special[0] - bottom);

        // Gaps between special floors
        for (int i = 1; i < special.length; i++) {
            maxGap = Math.max(maxGap, special[i] - special[i - 1] - 1);
        }

        // Gap after the last special floor
        maxGap = Math.max(maxGap, top - special[special.length - 1]);

        return maxGap;
    }
}
