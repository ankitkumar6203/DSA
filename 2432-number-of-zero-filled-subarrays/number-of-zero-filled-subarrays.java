class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;   // total subarrays
        long zeros = 0;   // current consecutive zeros

        for (int num : nums) {
            if (num == 0) {
                zeros++;        // extend the current zero streak
                count += zeros; // add subarrays ending at this position
            } else {
                zeros = 0;      // reset streak
            }
        }

        return count;
    }
}
