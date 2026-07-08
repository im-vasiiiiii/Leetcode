public class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = 6 * minutes;
        double hourAngle = 30 * (hour % 12) + 0.5 * minutes;
        double diff = Math.abs(hourAngle - minuteAngle);
        return Math.min(diff, 360 - diff);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.angleClock(12, 30)); // 165
        System.out.println(sol.angleClock(3, 30));  // 75
        System.out.println(sol.angleClock(3, 15));  // 7.5
    }
}
