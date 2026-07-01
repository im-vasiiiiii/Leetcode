class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long total = 0;
        for (int c : chalk) {
            total += c;
        }

        // Skip full rounds
        k %= total;

        // Find the student who cannot be served
        for (int i = 0; i < chalk.length; i++) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
        }

        // Should never reach here
        return -1;
    }
}
