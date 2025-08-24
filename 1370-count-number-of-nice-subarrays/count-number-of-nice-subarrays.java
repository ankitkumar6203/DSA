import java.util.HashMap;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case

        int count = 0, sum = 0;

        for (int num : nums) {
            // odd → 1, even → 0
            sum += (num % 2);

            // check if we have seen sum-k
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            // store frequency of current sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
