class Solution {
    public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];
    
    // Find the intersection point in the cycle
    do {
        slow = nums[slow];
        fast = nums[nums[fast]];
    } while (slow != fast);
    
    // Find the entrance to the cycle (duplicate number)
    slow = nums[0];
    while (slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
    }
    
    return slow;
}

}